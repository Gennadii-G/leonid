package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.UserDTO;
import com.spacefox.frida.domain.User;

import java.util.List;


public interface UserService {

    List<User> getAll();

    void save(User user);

    void save(UserDTO dto);

    User currentUser();

    boolean exists(String login);

    User getByLogin(String login);

    void update(User user);

    void update(UserDTO dto);

    User getById(Long id);

    List<UserDTO> getDTO(List<User> all);

    void delete(UserDTO dto);

    void delete(User user);

    void delete(Long id);

    UserDTO getDTO(User user);

    User getSU();
}
