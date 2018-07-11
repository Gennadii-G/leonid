package com.spacefox.frida.domain.catalogs;

import com.spacefox.frida.utils.DisplayName;

public enum TrampolineType {

    BIG(DisplayName.get("tramp.type.big"), 3),
    PROFESSIONAL(DisplayName.get("tramp.type.professional"), 2),
    NORMAL(DisplayName.get("tramp.type.normal"), 1),
    BABY_SIZE(DisplayName.get("tramp.type.babySize"), 0);

    private String displayName;
    private int id;

    TrampolineType(String displayName, int id) {
        this.displayName = displayName;
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }
}

