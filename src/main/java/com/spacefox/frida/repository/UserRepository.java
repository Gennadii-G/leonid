package com.spacefox.frida.repository;

import com.spacefox.frida.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    User findBylogin(String login);

    Optional<User> findFirstByName(String name);

    User existsByName(String name);
}
