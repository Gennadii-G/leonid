package com.spacefox.frida.domain;

import java.util.List;
import java.util.stream.Collectors;

public class TrampolineHall  extends DomainObject {

    private List<Order> orders;
    private List<Discount> discounts;
    private List<Trampoline> tramlins;
    private int price;
    private String name;
    private String address = "mockAddress";

    public TrampolineHall() {}

    public TrampolineHall(String name, List<Trampoline> tramlins, int price) {
        this.name = name;
        this.price = price;
    }

    public void setTramlins(List<Trampoline> tramlins) {
        this.tramlins = tramlins;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddress() {
        return address;
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
        return freeTramps();
    }

    public boolean orderTramp(){
        List<Trampoline> tramlins = this.tramlins.stream().filter(t -> !t.isOrdered()).collect(Collectors.toList());
        if(!tramlins.isEmpty()){
            tramlins.get(0).setOrdered(true);
            return true;
        }else{
            return false;
        }
    }

    @Override
    public String toString() {
        return "TrampolineHall: " +
                name + ", free tramps: " +
                freeTramps() + " / " +
                tramlins.size() + ", price:" +
                price;
    }

    public int freeTramps(){
        return (int) tramlins.stream().filter(t -> !t.isOrdered()).count();
    }
}
