package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.Roles;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name="jh_user")
public class User extends DomainObject {

    private String name;
    private String login;
    private String secondName;
    private String lastName;
    private String password;
    private Contact contact;
    private Date birthday;
    private boolean active;
    @Column(name="ROLE")
    private String role;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    public User() {}

    public User(String name, String password) {
        name = name;
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Set<Roles> getRoles() {
        return roles;
    }

    public void setRoles(Set<Roles> roles) {
        this.roles = roles;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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
