package com.spacefox.frida.services;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.DTO.ContactDTO;
import com.spacefox.frida.repository.ContactRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository repository;
    @Autowired
    private ModelMapper mapper;


    @Override
    public List<Contact> getAll() {
        return repository.findAll();
    }

    @Override
    public void save(Contact contact) {
        repository.save(contact);
    }

    @Override
    public void update(Contact contact) {
        if(repository.existsById(contact.getId())){
            repository.save(contact);
        }
    }

    @Override
    public void delete(long id) {
        if(repository.existsById(id)){
            repository.deleteById(id);
        }
    }

    @Override
    public void delete(Contact contact) {
        if(repository.existsById(contact.getId())){
            repository.delete(contact);
        }
    }

    @Override
    public Contact getById(long id) {
        return repository.findById(id).get();
    }

    @Override
    public ContactDTO getDTO(Contact contact) {
        return mapper.map(contact, ContactDTO.class);
    }

    @Override
    public List<ContactDTO> getDTO(List<Contact> contact) {
        return contact.stream().map(this::getDTO).collect(Collectors.toList());
    }

    @Override
    public long contactCount() {
        return repository.count();
    }
}
