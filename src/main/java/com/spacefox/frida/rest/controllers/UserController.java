package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.UserDTO;
import com.spacefox.frida.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @DeleteMapping("/user/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(UserDTO dto){
        userService.delete(dto);
    }

    @DeleteMapping("/user/delete/id")
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(Long id){
        userService.delete(id);
    }

    @GetMapping("/users")
    public List<UserDTO> allUsers() {
        return userService.getDTO(userService.getAll());
    }

    @PostMapping("/user/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@Valid UserDTO dto) {
        userService.save(dto);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO userById(@PathVariable Long id) {
        return userService.getDTO(userService.getById(id));
    }

    @PutMapping("/user/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(UserDTO dto){
        userService.update(dto);
    }
}
