package com.spacefox.frida.domain;

import com.spacefox.frida.utils.DateFormatterJH;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Date;

@Entity
@Table(name="jh_order")
@NoArgsConstructor @Setter @Getter
public class Order {

//    yyyy-MM-dd'T'hh:mm:ss.SSSZ

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="trampolineHall_id", referencedColumnName = "id")
    private TrampolineHall hall;
    @ManyToOne
    @JoinColumn(name="discount_id", referencedColumnName = "id")
    private Discount discount;
    @OneToOne
    private Employee employee;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="contact_id")
    private Contact contact;
    private int price;
    private int minuteAmount;
    private int trampsAmount;
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    private Date regDate;
    private String comment;
    private int startHour;

    public String mediumRegDate(){
        return DateFormatterJH.dateTimeFormat(this.regDate);
    }

    public String shortEventDate(){
        return DateFormatterJH.dateOnlyFormat(this.eventDate);
    }

//  getters and setters


    public int getStartHour() {
        return startHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

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


}
