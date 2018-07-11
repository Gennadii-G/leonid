package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Getter @Setter
public class TrampolineDTO {

    private Long id;
    @Size(max=40, message = "Длина не должна быть больше 40 символов")
    private String name;
    @Size(max=250, message = "Длина не должна быть больше 250 символов")
    private String Desc;
    private boolean isBroken;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastMaintenance;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate nextMaintenance;
    @NotNull(message = "Тип должен быть указан")
    private TrampolineType type;
    private TrampolineHall hall;
    private long hallId;
}
