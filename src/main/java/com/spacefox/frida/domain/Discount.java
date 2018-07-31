package com.spacefox.frida.domain;


import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Entity
@Table(name="jh_discount")
@Data
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder()
public class Discount {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private int discountFactor;
    @ToString.Exclude
    private String description;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private LocalDate startAvailability;
    @Column(nullable = false)
    private LocalDate endAvailability;

}
