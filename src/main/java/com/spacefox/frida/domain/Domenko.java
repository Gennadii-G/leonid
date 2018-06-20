package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class Domenko extends DomainObject {

    private String name;
    private int number;
    private boolean isYes;

}
