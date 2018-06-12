package com.spacefox.frida.repository;

import com.spacefox.frida.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findBylogin(String login);
}
