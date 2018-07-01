package com.spacefox.frida.domain.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DomenkoDTO {

    private String name;
    private int number;
    private boolean isYes;
    private boolean orNot;
    private String filename;
    private long size;
}
