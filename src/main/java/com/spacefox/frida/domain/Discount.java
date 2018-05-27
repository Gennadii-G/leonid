package com.spacefox.frida.domain;

public class Discount extends DomainObject {

    private boolean isWeekDayDiscount;
    private int discountFactor;
    private String name;
    private String Description;

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
