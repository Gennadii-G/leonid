package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Trampoline;

import java.time.LocalDateTime;
import java.util.List;

public interface TrampolineService {

    List<Trampoline> getAll();

    Trampoline getById(long id);

    void save(Trampoline tramp);

    void save(List<Trampoline> tramps);

    void save(TrampolineDTO dto);

    void update(Trampoline tramp);

    void delete(Trampoline tramp);

    TrampolineDTO convert(Trampoline trampoline);

    Trampoline convert(TrampolineDTO dto);

    List<TrampolineDTO> convert(List<Trampoline> trampolines);

    boolean isBooked(Trampoline trampoline, LocalDateTime from, LocalDateTime to);

    void delete(Long id);
}
