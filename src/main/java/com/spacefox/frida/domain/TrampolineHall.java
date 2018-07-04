package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jh_trampoline_hall")
@Getter @Setter @NoArgsConstructor @ToString
public class TrampolineHall{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

//    @OneToMany(mappedBy = "hall")
//    private List<Order> orders;
    @OneToMany(orphanRemoval=true)
    @JoinColumn(name="trampoline_id")
    private List<Trampoline> trampolines;
    private int price;
    private String name;
    private String address;
    private String phone;

    public int freeTrampsAmount(){
        int res = 0;
        if(!trampolines.isEmpty()){
            res = (int) trampolines.stream().filter(t -> !t.isOrdered()).count();
        }
        return res;
    }
}
