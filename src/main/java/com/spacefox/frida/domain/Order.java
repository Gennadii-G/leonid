package com.spacefox.frida.domain;

import org.springframework.format.annotation.DateTimeFormat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Order extends DomainObject {

    public Order() {
        this.contact = new Contact();
    }

    private String discountId;
    private int price;
    private int minuteAmount;
    private int trampsAmount;
    private int employeeId;
    private Contact contact;
    @DateTimeFormat(pattern = "yyyy-MM-ddTHH:mm")
    private Date eventDate;
    private Date regDate;
    private String hallId;
    private String comment;
    private boolean isCustomerAdult;


//  getters and setters
    public Contact getContact() {
        return contact;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getMinuteAmount() {
        return minuteAmount;
    }

    public void setMinuteAmount(int minuteAmount) {
        this.minuteAmount = minuteAmount;
    }

    public int getTrampsAmount() {
        return trampsAmount;
    }

    public void setTrampsAmount(int trampsAmount) {
        this.trampsAmount = trampsAmount;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public boolean getIsCustomerAdult() {
        return isCustomerAdult;
    }

    public void setIsCustomerAdult(boolean customerAdult) {
        isCustomerAdult = customerAdult;
    }

    public String getDiscountId() {
        return discountId;
    }

    public void setDiscountId(String discountId) {
        this.discountId = discountId;
    }

    public String getHallId() {
        return hallId;
    }

    public void setHallId(String hallId) {
        this.hallId = hallId;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }




    @Override
    public String toString() {

//        SimpleDateFormat formatter = new SimpleDateFormat();
//        formatter.applyPattern("yyyy-MM-dd");

        return "Order{" +
                "price=" + price +
                ", minuteAmount=" + minuteAmount +
                ", trampsAmount=" + trampsAmount +
                ", employeeId=" + employeeId +
                ", contact=" + contact +
                ", eventDate=" + eventDate +
                ", regDate=" + regDate +
                ", hallId='" + hallId + '\'' +
                ", comment='" + comment + '\'' +
                ", isCustomerAdult=" + isCustomerAdult +
                '}';
    }
}
