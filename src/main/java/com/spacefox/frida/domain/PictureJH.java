package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity
@Getter @Setter @NoArgsConstructor
public class PictureJH extends DomainObject{

    private String filename;
    private long size;
    private User uploadedBy;
//    private DataJH picture;


}
