package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.repository.TrampolineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.transaction.TransactionalException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrampolineServiceImpl implements TrampolineService {

    @Autowired
    private TrampolineRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TrampolineHallService hallService;
    @Autowired
    private OrderService orderService;

    @Override
    public List<Trampoline> getAll() {
        return repository.findAll();
    }

    @Override
    public Trampoline getById(long id) {
        return repository.getOne(id);
    }

    @Override
    public void save(Trampoline tramp) {
        tramp.setId(null);
        repository.save(tramp);
    }

    @Transactional
    @Override
    public void save(TrampolineDTO dto) {
        dto.setId(null);
        Trampoline tramp = mapper.map(dto, Trampoline.class);
        long hallId = dto.getHallId();

        if(hallService.exists(hallId)) {
            TrampolineHall hall = hallService.getById(hallId);
        }
        repository.save(tramp);
    }

    @Override
    public void update(Trampoline tramp) {
        if(repository.existsById(tramp.getId())){
            repository.save(tramp);
        }
    }


    @Override
    public void delete(Trampoline tramp) {
        if(repository.existsById(tramp.getId())){
            repository.delete(tramp);
        }
    }

    @Override
    public TrampolineDTO convert(Trampoline trampoline) {
        TrampolineDTO dto = mapper.map(trampoline, TrampolineDTO.class);
        return dto;
    }

    @Override
    public Trampoline convert(TrampolineDTO dto) {
        Trampoline trampoline = mapper.map(dto, Trampoline.class);
        return trampoline;
    }

    @Override
    public List<TrampolineDTO> convert(List<Trampoline> trampolines) {
        return trampolines.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public void save(List<Trampoline> tramps) {
        repository.saveAll(tramps);
    }

    @Override
    public boolean isBooked(Trampoline trampoline, LocalDateTime from, LocalDateTime to) {
        TrampolineHall hall = hallService.getByTrampoline(trampoline);
        List<Order> orders = orderService.getByHallandDate(hall, from.toLocalDate());
        long count = orders.stream().filter(ord -> {
            return orderService.hasIntersection(ord, from, to);
        }).count();

        return count > 0;
    }

    @Override
    public void delete(Long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }
}
