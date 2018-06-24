package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Domenko extends DomainObject {

    private String name;
    private int number;
    private boolean isYes;
    private boolean orNot;

}
