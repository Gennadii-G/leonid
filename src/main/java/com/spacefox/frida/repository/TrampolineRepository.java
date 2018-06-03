package com.spacefox.frida.repository;

import com.spacefox.frida.domain.Trampoline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrampolineRepository extends JpaRepository<Trampoline, Long> {
}
