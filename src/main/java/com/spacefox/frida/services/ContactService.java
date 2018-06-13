package com.spacefox.frida.services;

import com.spacefox.frida.domain.Contact;

import java.util.List;

public interface ContactService {

    List<Contact> getAll();

    void save(Contact disc);

}
