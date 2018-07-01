package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.repository.TrampolineHallRepository;
import com.spacefox.frida.utils.builders.TrampolineHallBuilder;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrampolineHallServiceImpl implements TrampolineHallService {

    @Autowired
    private TrampolineHallRepository repository;
    @Autowired
    private ModelMapper mapper;

    @Override
    public List<TrampolineHall> getAll() {
        return repository.findAll();
    }

    @Override
    public TrampolineHall getByName(String name) {
        return repository.findByName(name);
    }

    @Override
    public void save(TrampolineHall hall) {
        repository.save(hall);
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
    public TrampolineHallDTO getDTO(TrampolineHall hall) {
        return mapper.map(hall, TrampolineHallDTO.class);
    }

    @Override
    public List<TrampolineHallDTO> getDTO(List<TrampolineHall> halls) {
        return halls.stream().map(this::getDTO).collect(Collectors.toList());
    }
}
