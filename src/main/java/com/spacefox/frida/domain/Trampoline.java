package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.TrampolineType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="jh_trampoline")
@Getter @Setter @NoArgsConstructor
public class Trampoline extends DomainObject {

    private boolean isBroken;
    private boolean isOrdered;
    @Enumerated(EnumType.STRING)
    private TrampolineType type;

}
