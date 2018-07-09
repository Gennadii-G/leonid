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
    public void deleteDiscount(UserDTO dto){
        userService.delete(dto);
    }

    @GetMapping("/users")
    public List<UserDTO> allDiscounts() {
        return userService.getDTO(userService.getAll());
    }

    @PostMapping("/user/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveDiscount(@Valid UserDTO dto) {
        userService.save(dto);
    }

    @GetMapping("/user/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UserDTO discountById(@PathVariable Long id) {
        return userService.getDTO(userService.getById(id));
    }

    @PutMapping("/user/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updateDiscount(UserDTO dto){
        userService.update(dto);
    }
}
