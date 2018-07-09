package com.spacefox.frida.domain.DTO;

import lombok.Data;

import javax.validation.constraints.Pattern;

@Data
public class IdentifierDTO {

    @Pattern(regexp = "\\d*", message = "Идентификатор должен быть только числовым")
    private String targetId;
    @Pattern(regexp = "[\\d, ]*", message = "неправильный формат идентификаторов. Пример: '1, 2, 3, ...'")
    private String identifiers;
}
