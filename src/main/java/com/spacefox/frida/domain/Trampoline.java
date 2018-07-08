package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="jh_trampoline")
@Data
@NoArgsConstructor @ToString
public class Trampoline {

//    public Trampoline(TrampolineType type) {
//        this.type = type;
//    }

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
//    @ManyToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="hall_id", referencedColumnName = "id")
    private TrampolineHall hall;

}
