package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor
public class DomainObject implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long publicid;
}
