package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jh_trampoline_hall")
@Getter @Setter @NoArgsConstructor
public class TrampolineHall extends DomainObject {


    @OneToMany(mappedBy = "hall")
    private List<Order> orders;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="trampoline_id")
    private List<Trampoline> trampolines = new ArrayList<>();
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
