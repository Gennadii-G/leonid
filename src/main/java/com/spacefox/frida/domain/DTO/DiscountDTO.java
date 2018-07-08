package com.spacefox.frida.domain.DTO;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data @Builder
public class DiscountDTO {

    private Long id;
    @NotNull(message = "Необходимо указать фактор от 0 до 100")
    @Max(value = 100, message = "фактор не может быть больше 100%")
    @Min(value = 0, message = "фактор не может быть меньше 0%")
    private int discountFactor;
    @Size(max = 400, message="Размер текста должен быть меньше 400 символов")
    private String description;
    @NotNull(message = "У скидки обязательно должно быть название")
    private String name;

}
