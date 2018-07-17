package com.spacefox.frida.domain.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Data @NoArgsConstructor @AllArgsConstructor
@Builder
public class OrderCreateDTO {

    private long hall;
    private long discount;
    private long employee;
    private long customer;
    @Min(value = 1, message = "Должно быть указано количество батутов")
    private int trampsAmount;
    @NotNull(message = "Не указана дата записи")
    @Size(max=500, message = "Превышен максимальный размер комментария в 500 символов")
    private String comment;
    @NotNull(message = "Не указан час посещения")
    private int startHour;
    private LocalDateTime regDate;
    @NotNull(message = "Должнобыть указано время начала записи")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingFrom;
    @NotNull(message = "Должнобыть указано время окончания записи")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingTo;
}
