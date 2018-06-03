package com.spacefox.frida.domain;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Entity
@Table(name="jh_user")
public class User extends DomainObject {

    private String name;
    private String login;
    private String secondName;
    private String lastName;
    @Transient
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
