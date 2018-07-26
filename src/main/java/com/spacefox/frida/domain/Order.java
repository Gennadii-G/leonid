package com.spacefox.frida.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Table(name="jh_order")
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Order {

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
    @ManyToOne()
    @JoinColumn(name = "employee_id", referencedColumnName = "id")
    private User employee;
    @ManyToOne()
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    private int price;
    @Column(nullable = false)
    private int trampsAmount;
    private LocalDate eventDate;
    private LocalDate regDate;
    private LocalDateTime bookingFrom;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime bookingTo;
    private String comment;

    public String mediumRegDate(){
        return regDate.format(DateTimeFormatter.ISO_DATE);
    }
}
