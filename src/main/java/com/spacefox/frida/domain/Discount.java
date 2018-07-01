package com.spacefox.frida.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="jh_discount")
@Getter @Setter @NoArgsConstructor
@ToString(callSuper=true, includeFieldNames=true)
public class Discount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int discountFactor;
    @ToString.Exclude
    private String description;
    private String name;

}
