package com.spacefox.frida.services;



import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Trampoline;

import java.util.List;

public interface TrampolineService {

    List<Trampoline> getAll();

    Trampoline getById(long id);

    void save(Trampoline tramp);

    void save(List<Trampoline> tramps);

    void save(TrampolineDTO dto);

    void update(TrampolineDTO dto);

    void update(Trampoline tramp);

    void delete(TrampolineDTO dto);

    void delete(Trampoline tramp);

}
