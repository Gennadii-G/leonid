package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.catalogs.Roles;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class UserDTO {

    private Long id;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String name;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String login;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String secondName;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String lastName;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String password;
    private List<Contact> contacts;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;
    private boolean active;

    private Set<Roles> roles;

}
