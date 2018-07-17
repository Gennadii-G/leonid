package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="jh_trampoline")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Trampoline {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(length=40)
    private String name;
    @Column(length=250)
    private String description;
    private boolean isBroken;
    private LocalDate lastMaintenance;
    private LocalDate nextMaintenance;
    @Enumerated(EnumType.STRING)
    private TrampolineType type;

}
