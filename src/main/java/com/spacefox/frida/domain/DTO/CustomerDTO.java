package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Contact;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

@Data
public class CustomerDTO {

    private Long id;
    @Size(min = 4, max = 50, message="Размер имени должен быть меньше 4 - 50 символов")
    private String Name;
    @Size(min = 1, max = 4, message="Должно быть указано 1 - 4 контактов")
    private List<Contact> contacts;
    @Size(max = 500, message="Превышен максимальный размер текста в 500 символов")
    private String details;
}
