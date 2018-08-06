package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.repository.TrampolineHallRepository;
import com.spacefox.frida.utils.builders.TrampolineHallBuilder;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
public class TrampolineHallServiceImpl implements TrampolineHallService {

    @Autowired
    private TrampolineHallRepository repository;
    @Autowired
    private ModelMapper mapper;
    @Autowired
    private TrampolineService trampolineService;
    @Autowired
    private OrderService orderService;

    @Override
    public List<TrampolineHall> getAll() {
        return repository.findAll();
    }

    @Override
    public TrampolineHall getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public TrampolineHall save(TrampolineHall hall) {
        return repository.save(hall);
    }

    @Override
    public void save(TrampolineHall hall, int trampsAmount) {
        TrampolineHallBuilder builder = new TrampolineHallBuilder();
        builder.fillHall(hall);
        builder.withTramps(trampsAmount, TrampolineType.NORMAL);
        repository.save(builder.create());
    }

    @Override
    public void save(TrampolineHallDTO dto) {
        TrampolineHall hall = mapper.map(dto, TrampolineHall.class);
        save(hall, dto.getTrampsAmount());
    }

    @Override
    public void update(TrampolineHallDTO dto) {
        TrampolineHall hall = mapper.map(dto, TrampolineHall.class);
        update(hall);
    }

    @Override
    public void update(TrampolineHall hall) {
        if(repository.existsById(hall.getId())){
            repository.save(hall);
        }
    }

    @Override
    public void delete(TrampolineHallDTO dto) {
        TrampolineHall hall = mapper.map(dto, TrampolineHall.class);
        repository.delete(hall);
    }

    @Override
    public TrampolineHallDTO convert(TrampolineHall hall) {
        return mapper.map(hall, TrampolineHallDTO.class);
    }

    @Override
    public TrampolineHall convert(TrampolineHallDTO dto) {
        return mapper.map(dto, TrampolineHall.class);
    }

    @Override
    public List<TrampolineHallDTO> convert(List<TrampolineHall> halls) {
        return halls.stream().map(this::convert).collect(Collectors.toList());
    }

    @Override
    public void createTrampolineHall(TrampolineHall hall, int trampsAmount) {

    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public void createTrampolineHall(TrampolineHallDTO dto) {
        TrampolineHall hall = mapper.map(dto, TrampolineHall.class);
        createTrampolines(hall, dto.getTrampsAmount(), TrampolineType.NORMAL);
        repository.save(hall);
    }

    @Transactional(propagation=Propagation.MANDATORY)
    private void createTrampolines(TrampolineHall hall, int trampsAmount, TrampolineType type){
        List<Trampoline> tramps = new ArrayList<>();

        for(int i = 0; i < trampsAmount; i++) {
            Trampoline tramp = new Trampoline();
            tramp.setType(type);
            tramps.add(tramp);
        }
        trampolineService.save(tramps);
        hall.setTrampolines(tramps);
    }

    @Override
    public boolean exists(long id) {
        return repository.existsById(id);
    }

    @Override
    public TrampolineHall getById(long id) {
        return repository.getOne(id);
    }

    @Transactional
    @Override
    public void addTrampsById(String targetHallId, String trampsIds) {
        long hallId = Long.parseLong(targetHallId.trim());
        TrampolineHall hall = getById(hallId);
        log.info("добавление трамлинов в зал " + hall.getName());

        String[] idsAsStr = trampsIds.replaceAll("\\s+","").split(",");
        Set<Long> ids = Arrays.stream(idsAsStr)
                .map(Long::parseLong).collect(Collectors.toSet());

        List<Trampoline> tramps = ids.stream()
                .map( id -> trampolineService.getById(id))
                .collect(Collectors.toList());

        hall.setTrampolines(tramps);
        tramps.stream().forEach(tramp -> {
            trampolineService.save(tramp);
        });
        repository.save(hall);
        log.info("В зал " + hall.getName() + " добавлено " + tramps.size() + " батутов.");
    }

    @Override
    public boolean hasEnoughTramps(LocalDateTime from,
                                   LocalDateTime to,
                                   int requiredAmount,
                                   TrampolineHall hall) {
        int availableTramps = -1;

        List<Order> orders = orderService.getByHallandDate(hall, from.toLocalDate());
        int count = orders.stream().filter(ord -> orderService.hasIntersection(ord, from, to))
                .mapToInt(Order::getTrampsAmount).sum();

        availableTramps = hall.getTrampolines().size() - count;

        return availableTramps >= requiredAmount;
    }

    @Override
    public long hallsCount() {
        return repository.count();
    }

    @Override
    public TrampolineHall getByTrampoline(Trampoline trampoline) {
        return repository.findByTrampoline(trampoline.getId());
    }

    @Override
    public Long profit(Long id) {
        if(!repository.existsById(id)){
            throw new IllegalArgumentException("hall not found");
        }
        TrampolineHall hall = repository.getOne(id);
        List<Order> orders = orderService.getByHall(hall);
        return (long) orders.stream().mapToInt(Order::getPrice).sum();
    }

    @Override
    public boolean exist(Long id) {
        return repository.existsById(id);
    }
}
