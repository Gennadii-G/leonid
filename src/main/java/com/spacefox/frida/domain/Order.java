package com.spacefox.frida.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="jh_order")
@NoArgsConstructor @Data
public class Order {

//    yyyy-MM-dd'T'hh:mm:ss.SSS

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name="trampolineHall_id", referencedColumnName = "id")
    private TrampolineHall hall;
    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private List<Trampoline> trampolines;
    @ManyToOne
    @JoinColumn(name="discount_id", referencedColumnName = "id")
    private Discount discount;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private User employee;
    private int price;
//    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
//    private LocalDate eventDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDate regDate;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingTo;
    private String comment;

    public String mediumRegDate(){
        return regDate.format(DateTimeFormatter.ISO_DATE);
    }
}
