package com.spacefox.frida.domain;


import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="jh_discount")
public class Discount extends DomainObject {

    public Discount() {
    }

    private int discountFactor;
    private String Description;
    private String name;

    public int getDiscountFactor() {
        return discountFactor;
    }

    public void setDiscountFactor(int discountFactor) {
        this.discountFactor = discountFactor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }
}
