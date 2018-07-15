package com.spacefox.frida.domain;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jh_trampoline_hall")
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class TrampolineHall{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
    private List<Order> orders;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
    private List<Trampoline> trampolines;

    private int price;
    @Column(length=40)
    private String name;
    @Column(length=120)
    private String address;
    private String phone;
}
