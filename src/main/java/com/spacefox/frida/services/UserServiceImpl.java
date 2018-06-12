package com.spacefox.frida.services;

import com.spacefox.frida.domain.User;
import com.spacefox.frida.repository.UserRepository;
import com.spacefox.frida.utils.UserUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Override
    public List<User> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(User user) {
        user.setActive(true);
        repository.save(user);
    }

    @Override
    public User currentUser() {
        return repository.findBylogin(UserUtil.currentUser());
    }

    @Override
    public boolean exists(String login) {
        return repository.findBylogin(login) != null;
    }

    @Override
    public User getByLogin(String login) {
        return repository.findBylogin(login);
    }
}
