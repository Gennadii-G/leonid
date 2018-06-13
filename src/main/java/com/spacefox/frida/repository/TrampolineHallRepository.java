package com.spacefox.frida.repository;

import com.spacefox.frida.domain.TrampolineHall;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrampolineHallRepository extends JpaRepository<TrampolineHall, Long> {

    TrampolineHall findByName(String name);
}
