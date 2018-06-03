package com.spacefox.frida.domain.catalogs;

import com.spacefox.frida.utils.DisplayName;

public enum TrampolineType {

    BIG(DisplayName.get("tramp.type.big")),
    PROFESSIONAL(DisplayName.get("tramp.type.professional")),
    NORMAL(DisplayName.get("tramp.type.normal")),
    BABY_SIZE(DisplayName.get("tramp.type.babySize"));

    private String displayName;

    TrampolineType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

