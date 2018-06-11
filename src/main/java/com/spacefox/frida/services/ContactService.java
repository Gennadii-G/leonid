package com.spacefox.frida.services;

import com.spacefox.frida.domain.Contact;

import java.util.List;

public interface ContactService {

    public List<Contact> getAll();

    public void save(Contact disc);

}
