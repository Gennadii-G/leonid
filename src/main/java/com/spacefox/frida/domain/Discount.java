package com.spacefox.frida.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="jh_discount")
@Getter @Setter @NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class Discount extends DomainObject {

    private int discountFactor;
    @ToString.Exclude
    private String description;
    private String name;

}
