package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.catalogs.Roles;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    private String name;
    private String login;
    private String secondName;
    private String lastName;
    private String password;
    private List<Contact> contacts;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private boolean active;

    private Set<Roles> roles;

}
