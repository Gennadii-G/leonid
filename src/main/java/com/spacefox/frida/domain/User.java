package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.Roles;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="jh_user")
@Getter @Setter @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    private String login;
    private String secondName;
    private String lastName;
    private String password;
    @OneToMany(cascade=CascadeType.ALL)
    @JoinColumn(name="user_id")
    private List<Contact> contacts;
    private Date birthday;
    private boolean active;
    @Column(name="ROLE")
    private String role;

    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @CollectionTable(name="user_roles", joinColumns = @JoinColumn(name="user_id"))
    @Enumerated(EnumType.STRING)
    private Set<Roles> roles;

    public User(String name, String password) {
        name = name;
        this.password = password;
    }

}
