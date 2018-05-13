package com.spacefox.frida.domain;

import java.util.Date;

public class User extends DomainObject {

    private int id;
    private String name;
    private String secondName;
    private String lastName;
    private String password;
    private Contact contact;
    private boolean isAdult;
    private Date birthday;

    public User() {}

    public User(String name, String password) {
        name = name;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String firstName) {
        this.name = firstName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
