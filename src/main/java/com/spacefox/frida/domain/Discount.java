package com.spacefox.frida.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="jh_discount")
@Getter @Setter @NoArgsConstructor
public class Discount extends DomainObject {

    private int discountFactor;
    private String description;
    private String name;

}
