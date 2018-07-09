package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;

@NoArgsConstructor @Getter @Setter
public class OrderDTO {

    private TrampolineHall hall;
    private Discount discount;
    private User employee;
    private Customer customer;
    private int price;
    @NotNull(message = "Поле продолжительности обязательно к заполнению")
    private int minuteAmount;
    @Min(value = 1, message = "Должно быть указано количество батутов")
    private int trampsAmount;
    @NotNull(message = "Не указана дата записи")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate eventDate;
    private Date regDate;
    @Size(max=500, message = "Превышен максимальный размер комментария в 500 символов")
    private String comment;
    @NotNull(message = "Не указан час посещения")
    private int startHour;
}
