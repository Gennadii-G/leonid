package com.spacefox.frida.services;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import com.spacefox.frida.repository.TrampolineHallRepository;
import com.spacefox.frida.utils.factory.TrampolineHallBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrampolineHallServiceImpl implements TrampolineHallService {

    @Autowired
    private TrampolineHallRepository repository;

    @Override
    public List<TrampolineHall> getAll() {
        return repository.findAll();
    }

    @Override
    public TrampolineHall getByName(String name) {
        repository.findByName(name);
        return null;
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
}
