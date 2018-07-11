package com.spacefox.frida.domain;


import lombok.*;

import javax.persistence.*;
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
    private String name;
    private LocalDate startAvailability;
    private LocalDate endAvailability;

}
