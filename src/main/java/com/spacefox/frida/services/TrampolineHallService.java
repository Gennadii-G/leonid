package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;

import java.time.LocalDateTime;
import java.util.List;


public interface TrampolineHallService {

    List<TrampolineHall> getAll();

    TrampolineHall getByName(String name);

    TrampolineHall save(TrampolineHall hall);

    void save(TrampolineHall hall, int trampsAmount);

    @Deprecated
    void createTrampolineHall(TrampolineHall hall, int trampsAmount);

    void createTrampolineHall(TrampolineHallDTO hallDTO);

    void save(TrampolineHallDTO dto);

    void update(TrampolineHallDTO dto);

    void update(TrampolineHall hall);

    void delete(TrampolineHallDTO dto);

    TrampolineHallDTO convert(TrampolineHall hall);

    TrampolineHall convert(TrampolineHallDTO dto);

    List<TrampolineHallDTO> convert(List<TrampolineHall> halls);

    boolean exists(long id);

    TrampolineHall getById(long id);

    void addTrampsById(String targetHall, String trampsIds);

    boolean hasEnoughTramps(LocalDateTime from, LocalDateTime to, int amount, TrampolineHall hall);

    long hallsCount();

    TrampolineHall getByTrampoline(Trampoline trampoline);

    Long profit(Long id);

    boolean exist(Long id);
}
