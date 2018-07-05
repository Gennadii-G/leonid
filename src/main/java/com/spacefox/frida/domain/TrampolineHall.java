package com.spacefox.frida.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jh_trampoline_hall")
@Data
public class TrampolineHall{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "hall")
    private List<Trampoline> trampolines;
    private int price;
    private String name;
    private String address;
    private String phone;
}
