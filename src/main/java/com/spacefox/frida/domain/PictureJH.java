package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

//@Entity
//@Table(name="jh_picture")
@Getter @Setter @NoArgsConstructor
public class PictureJH {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String filename;
    private long size;
    private User uploadedBy;
//    private DataJH picture;


}
