package com.spacefox.frida.domain.DTO;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class OrderCreateDTO {

    private Long hall;
    private Long discount;
    private Long employee;
    private Long customer;
    @NotNull(message = "Не указано количество батутов")
    @Min(value = 1, message = "Должно быть указано количество батутов")
    private Integer trampsAmount;
    @NotNull(message = "Не указана дата записи")
    @Size(max=500, message = "Превышен максимальный размер комментария в 500 символов")
    private String comment;
    private LocalDateTime regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate eventDate;
    @NotNull(message = "Должнобыть указано время начала записи")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingFrom;
    @NotNull(message = "Должнобыть указано время окончания записи")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingTo;
}
