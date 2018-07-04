package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="jh_trampoline")
@Getter @Setter @NoArgsConstructor @ToString
public class Trampoline {

    public Trampoline(TrampolineType type) {
        this.type = type;
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private boolean isBroken;
    private boolean isOrdered;
    @Enumerated(EnumType.STRING)
    private TrampolineType type;

}
