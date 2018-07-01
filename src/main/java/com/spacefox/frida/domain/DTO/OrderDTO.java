package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Contact;
import com.spacefox.frida.domain.Discount;
import com.spacefox.frida.domain.Employee;
import com.spacefox.frida.domain.TrampolineHall;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@NoArgsConstructor @Getter @Setter
public class OrderDTO {

    private TrampolineHall hall;
    private Discount discount;
    private Employee employee;
    private Contact contact;
    private int price;
    private int minuteAmount;
    private int trampsAmount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    private Date regDate;
    private String comment;
    private int startHour;
}
