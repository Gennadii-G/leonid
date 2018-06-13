package com.spacefox.frida.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="jh_trampoline_hall")
public class TrampolineHall extends DomainObject {


    @OneToMany(mappedBy = "hall")
    private List<Order> orders;
//    private List<Discount> availableDiscounts;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval=true)
    @JoinColumn(name="trampoline_id")
    private List<Trampoline> trampolines = new ArrayList<>();
    private int price;
    private String name;
    private String address;
    private String phone;

    public TrampolineHall() {
    }

    public List<Trampoline> getTrampolines() {
        return trampolines;
    }

    public void setTrampolines(List<Trampoline> trampolines) {
        this.trampolines = trampolines;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getFreeTramps(){
        return freeTrampsAmount();
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "TrampolineHall: " +
                name + ", free tramps: " +
                freeTrampsAmount() + " / " +
                trampolines.size() + ", price:" +
                price;
    }

    public int freeTrampsAmount(){
        int res = 0;
        if(!trampolines.isEmpty()){
            res = (int) trampolines.stream().filter(t -> !t.isOrdered()).count();
        }
        return res;
    }
}
