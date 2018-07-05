package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
public class TrampolineDTO {

    private Long id;
    private String name;
    private String Desc;
    private boolean isBroken;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate lastMaintenance;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate nextMaintenance;
    @NotNull
    private TrampolineType type;
    private TrampolineHall hall;
    private long hallId;
}
