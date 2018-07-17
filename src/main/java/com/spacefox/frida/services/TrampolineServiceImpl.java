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
        repository.save(tramp);
    }

    @Transactional
    @Override
    public void save(TrampolineDTO dto) {
        Trampoline tramp = mapper.map(dto, Trampoline.class);
        long hallId = dto.getHallId();

        if(hallService.exists(hallId)) {
            TrampolineHall hall = hallService.getById(hallId);
        }
        repository.save(tramp);
    }

    @Override
    public void update(TrampolineDTO dto) {
        if(repository.existsById(dto.getId())){
            save(dto);
        } else {
            throw new TransactionalException("зал не найден", new IllegalArgumentException());
        }
    }

    @Override
    public void update(Trampoline tramp) {
        repository.save(tramp);
    }

    @Override
    public void delete(TrampolineDTO dto) {
        Trampoline tramp = mapper.map(dto, Trampoline.class);
        if(repository.existsById(tramp.getId())){
            repository.delete(tramp);
        }
    }

    @Override
    public void delete(Trampoline tramp) {
        if(repository.existsById(tramp.getId())){
            repository.delete(tramp);
        }
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
}
