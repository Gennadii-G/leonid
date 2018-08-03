package com.spacefox.frida.domain.DTO;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class ContactDTO {

    private Long id;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String firstName;
    @Size(max = 40, message="Превышен максимальный размер текста в 40 символов")
    private String lastName;
    @Size(max = 15, message="Превышен максимальный размер текста в 15 символов")
    private String phoneNumber;
    @Size(max = 120, message="Превышен максимальный размер текста в 120 символов")
    private String Address;
    private int age;

}
