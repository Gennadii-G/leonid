package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Trampoline;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@NoArgsConstructor @Getter
@Setter
public class TrampolineHallDTO {

    @NotNull(message = "Цена должна быть указана")
    @Min(value = 0, message = "Цена не может быть меньше нуля")
    private int price;
    @NotNull(message = "Название должно быть указано")
    @Size(min = 1, max = 20, message = "Неподходящее название")
    private String name;
    @NotNull(message = "Адрес должен быть указан")
    @Size(min = 3, max = 70, message = "Неподходящий адрес")
    private String address;
    @NotNull(message = "Телефон должен быть указан")
    @Pattern(regexp = "^((8|\\+7)[\\- ]?)?(\\(?\\d{3}\\)?[\\- ]?)?[\\d\\- ]{7,10}$",
            message = "Неподходящий номер телефона")
    private String phone;
    @Min(value = 1, message = "Должен быть минимум 1 батут")
    private int trampsAmount;
    private List<Trampoline> trampolines;

}
