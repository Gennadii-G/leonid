package com.spacefox.frida.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="jh_order")
public class Order extends DomainObject {

    public Order() {
    }

    @ManyToOne
    @JoinColumn(name="trampolineHall_id", referencedColumnName = "publicid")
    private TrampolineHall hall;
    @ManyToOne
    @JoinColumn(name="discount_id", referencedColumnName = "publicid")
    private Discount discount;
    @OneToOne
    private Employee employee;
    @ManyToOne
    @JoinColumn(name="contact_id")
    private Contact contact;
    private int price;
    private int minuteAmount;
    private int trampsAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    private Date regDate;
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

    public TrampolineHall getHall() {
        return hall;
    }

    public void setHall(TrampolineHall hall) {
        this.hall = hall;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public String toString() {

//        SimpleDateFormat formatter = new SimpleDateFormat();
//        formatter.applyPattern("yyyy-MM-dd");

        return "Order{" +
                "price=" + price +
                ", minuteAmount=" + minuteAmount +
                ", trampsAmount=" + trampsAmount +
                ", employeeId=" + 123 +
                ", contact=" + contact +
                ", eventDate=" + eventDate +
                ", regDate=" + regDate +
                ", comment='" + comment + '\'' +
                ", isCustomerAdult=" + isCustomerAdult +
                '}';
    }
}
