package com.spacefox.frida.rest.DTO;

import com.spacefox.frida.domain.DomainObject;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DomenkoDTO extends DomainObject {

    private String name;
    private int number;
    private boolean isYes;
    private boolean orNot;
    private String filename;
    private long size;
}
