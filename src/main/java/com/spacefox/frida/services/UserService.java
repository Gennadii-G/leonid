package com.spacefox.frida.services;

import com.spacefox.frida.domain.User;

import java.util.List;


public interface UserService {

    List<User> getAll();

    void save(User user);

    User currentUser();

    boolean exists(String login);

    User getByLogin(String login);
}
