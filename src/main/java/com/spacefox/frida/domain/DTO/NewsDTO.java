package com.spacefox.frida.domain.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import com.spacefox.frida.utils.Transfer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@ToString
public class NewsDTO {

    @JsonView({Transfer.Update.class})
    private Long id;

    @JsonView({Transfer.Info.class, Transfer.Update.class})
    @Pattern(regexp = "^([a-zА-Я0-9_-]{2,90})(.)(jpg|jpeg|JPG|png|PNG)$",
            message = "Неподходящее название изображения")
    private String picture;

    @JsonView({Transfer.Info.class, Transfer.Update.class})
    @NotNull(message="Должен быть указан заголовок")
    private String title;

    @JsonView({Transfer.Info.class, Transfer.Update.class})
    @Size(min = 3, message="Размер текста должен быть больше")
    private String body;

    @JsonView({Transfer.Info.class, Transfer.Update.class})
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date publicationDate;

    @JsonView({Transfer.Admin.class})
    private Date createdDate;
}
