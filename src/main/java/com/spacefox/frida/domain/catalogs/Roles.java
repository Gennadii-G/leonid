package com.spacefox.frida.domain.catalogs;

import com.spacefox.frida.utils.DisplayName;

public enum Roles {

    GUEST(0, DisplayName.get("sec.guest.type"), DisplayName.get("sec.guest.name")),
    EMPLOYEE(50, DisplayName.get("sec.employee.type"), DisplayName.get("sec.employee.name")),
    ODMEN(700, DisplayName.get("sec.odm.type"), DisplayName.get("sec.odm.name"));

    private String type;
    private String name;
    private int accessLvl;

    Roles(int lvl, String type, String name) {
        this.accessLvl = lvl;
        this.type = type;
        this.name = name;
    }

    public int getAccessLvl() {
        return accessLvl;
    }

    public String type() {
        return type;
    }

    public String getName() {
        return name;
    }
}
