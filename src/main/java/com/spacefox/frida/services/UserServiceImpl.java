package com.spacefox.frida.services;

import com.spacefox.frida.domain.DTO.UserDTO;
import com.spacefox.frida.domain.User;
import com.spacefox.frida.repository.UserRepository;
import com.spacefox.frida.utils.UserUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private ModelMapper mapper;

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

    @Override
    public void save(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        repository.save(user);
    }

    @Override
    public void update(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        if(repository.existsById(dto.getId())){
            repository.save(user);
        }
    }

    @Override
    public User getById(Long id) {
        return repository.getOne(id);
    }

    @Override
    public List<UserDTO> getDTO(List<User> users) {
        return users.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public void delete(UserDTO dto) {
        User user = mapper.map(dto, User.class);
        if(repository.existsById(dto.getId())) {
            repository.delete(user);
        }
    }

    @Override
    public void delete(User user) {
        if(repository.existsById(user.getId())){
            repository.delete(user);
        }
    }

    @Override
    public UserDTO getDTO(User user) {
        return mapper.map(user, UserDTO.class);
    }

    @Override
    public void update(User user) {
        if(repository.existsById(user.getId())){
            repository.save(user);
        }
    }
}
