package com.spacefox.frida.services;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.DTO.ContactDTO;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    void save(Contact disc);

    void update(Contact contact);

    void delete(long id);

    void delete(Contact contact);

    Contact getById(long id);

    ContactDTO getDTO(Contact contact);

    List<ContactDTO> getDTO(List<Contact> contact);
}
