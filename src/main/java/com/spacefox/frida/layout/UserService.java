package com.spacefox.frida.layout;


import com.spacefox.frida.domain.User;
import java.util.List;

public interface UserService {

    public List<User> getAll();

    public User getByName(String name);
}
