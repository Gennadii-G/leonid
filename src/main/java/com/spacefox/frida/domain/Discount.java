package com.spacefox.frida.domain;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="jh_discount")
@Data @Builder
public class Discount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int discountFactor;
    @ToString.Exclude
    private String description;
    private String name;

}
