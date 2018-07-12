package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.DTO.ContactDTO;
import com.spacefox.frida.services.ContactService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private ModelMapper mapper;

    @DeleteMapping("/contact/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deletecontact(ContactDTO dto){
        contactService.delete(mapper.map(dto, Contact.class));
    }

    @GetMapping("/contacts")
    public List<ContactDTO> allcontacts() {
        return contactService.getDTO(contactService.getAll());
    }

    @PostMapping("/contact/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void savecontact(@Valid ContactDTO dto) {
        contactService.save(mapper.map(dto, Contact.class));
    }

    @GetMapping("/contact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactDTO contactById(@PathVariable Long id) {
        return contactService.getDTO(contactService.getById(id));
    }

    @PutMapping("/picture/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updatecontact(ContactDTO dto){
        contactService.update(mapper.map(dto, Contact.class));
    }
}
