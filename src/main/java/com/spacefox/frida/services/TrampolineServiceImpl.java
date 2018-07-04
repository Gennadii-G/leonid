package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.repository.TrampolineRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrampolineServiceImpl implements TrampolineService {

    @Autowired
    private TrampolineRepository repository;
    @Autowired
    private ModelMapper mapper;

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

    @Override
    public void save(TrampolineDTO dto) {
        Trampoline tramp = mapper.map(dto, Trampoline.class);
        repository.save(tramp);
    }

    @Override
    public void update(TrampolineDTO dto) {
        Trampoline tramp = mapper.map(dto, Trampoline.class);
        if(repository.existsById(tramp.getId())){
            repository.save(tramp);
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
}