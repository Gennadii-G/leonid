package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Customer;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.User;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderDTO {

    private TrampolineHall hall;
    private Discount discount;
    private User employee;
    private Customer customer;
    private int price;
    @Min(value = 1, message = "Должно быть указано количество батутов")
    private int trampsAmount;
    @NotNull(message = "Не указана дата записи")
    @Size(max=500, message = "Превышен максимальный размер комментария в 500 символов")
    private String comment;
    @NotNull(message = "Не указан час посещения")
    private int startHour;
    private LocalDate regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate eventDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingTo;
}
