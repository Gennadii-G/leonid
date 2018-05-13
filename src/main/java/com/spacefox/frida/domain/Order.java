package com.spacefox.frida.domain;

import java.util.Date;

public class Order extends DomainObject {

    private int price;
    private int minuteAmount;
    private int hoursAmount;
    private Contact consumer;
    private Date date;
}
