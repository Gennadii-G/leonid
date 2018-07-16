package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.TrampolineHall;

import java.time.LocalDateTime;
import java.util.List;


public interface TrampolineHallService {

    List<TrampolineHall> getAll();

    TrampolineHall getByName(String name);

    void save(TrampolineHall hall);

    void save(TrampolineHall hall, int trampsAmount);

    @Deprecated
    void createTrampolineHall(TrampolineHall hall, int trampsAmount);

    void createTrampolineHall(TrampolineHallDTO hallDTO);

    void save(TrampolineHallDTO dto);

    void update(TrampolineHallDTO dto);

    void update(TrampolineHall hall);

    void delete(TrampolineHallDTO dto);

    TrampolineHallDTO getDTO(TrampolineHall hall);

    List<TrampolineHallDTO> getDTO(List<TrampolineHall> halls);

    boolean exists(long id);

    TrampolineHall getById(long id);

    void addTrampsById(String targetHall, String trampsIds);

    boolean hasEnoughTramps(LocalDateTime from, LocalDateTime to, int amount, TrampolineHall hall);
}
