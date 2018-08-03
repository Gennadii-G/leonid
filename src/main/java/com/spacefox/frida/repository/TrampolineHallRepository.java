package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.domain.TrampolineHall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TrampolineHallRepository extends JpaRepository<TrampolineHall, Long> {

    String FIND_BY_TRAMPOLINE = "SELECT * FROM jh_trampoline_hall th LEFT JOIN th.trampolines tr where tr.id=?1";

    TrampolineHall findByName(String name);

    @Query(value = FIND_BY_TRAMPOLINE, nativeQuery = true)
    TrampolineHall findByTrampoline(long trampolineId);
}
