package com.spacefox.frida.services;

import com.spacefox.frida.domain.User;

import java.util.List;


public interface UserService {

    public List<User> getAll();

    public void save(User user);

    public User currentUser();

    public boolean exists(String login);

    public User getByLogin(String login);
}
