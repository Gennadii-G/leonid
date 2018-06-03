package com.spacefox.frida.domain;

import com.spacefox.frida.domain.catalogs.TrampolineType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

@Entity
@Table(name="jh_trampoline")
public class Trampoline extends DomainObject {

    private boolean isBroken;
    private boolean isOrdered;
    @Enumerated(EnumType.STRING)
    private TrampolineType type;

    public Trampoline() {
    }

    public Trampoline(TrampolineType type) {
        this.type = type;
    }

    public TrampolineType getType() {
        return type;
    }

    public void setType(TrampolineType type) {
        this.type = type;
    }

    public boolean isBroken() {
        return isBroken;
    }

    public void setBroken(boolean broken) {
        isBroken = broken;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    public void setOrdered(boolean ordered) {
        isOrdered = ordered;
    }

}
