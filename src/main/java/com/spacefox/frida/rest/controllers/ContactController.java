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

@RestController
public class ContactController {

    @Autowired
    private ContactService contactService;
    @Autowired
    private ModelMapper mapper;

    @DeleteMapping("/contact/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deletecontact(@PathVariable Long id){
        contactService.delete(id);
    }

    @GetMapping("/contact/all")
    public List<ContactDTO> allcontacts() {
        return contactService.convert(contactService.getAll());
    }

    @PostMapping("/contact/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void savecontact(@RequestBody @Valid ContactDTO dto) {
        contactService.save(mapper.map(dto, Contact.class));
    }

    @GetMapping("/contact/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContactDTO contactById(@PathVariable Long id) {
        return contactService.convert(contactService.getById(id));
    }

    @PutMapping("/picture/update/")
    @ResponseStatus(HttpStatus.OK)
    public void updatecontact(ContactDTO dto){
        contactService.update(mapper.map(dto, Contact.class));
    }
}
