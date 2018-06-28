package com.spacefox.frida.domain.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.beans.Transient;
import java.util.Date;

@Getter @Setter
@ToString
public class NewsDTO {

    private Long id;

    @Pattern(regexp = "^([a-zА-Я0-9_-]{0,90})(.)(jpg|jpeg|JPG|png|PNG)$",
            message = "Неподходящее название изображения")
    private String picture;

    @NotNull(message="Должен быть указан заголовок")
    private String title;

    @Size(min = 3, message="Размер текста должен быть больше")
    private String body;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @org.springframework.data.annotation.Transient
    private Date createdDate;
}
