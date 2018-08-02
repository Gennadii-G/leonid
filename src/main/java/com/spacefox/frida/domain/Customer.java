package com.spacefox.frida.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="jh_customer")
@Data
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String Name;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name="customer_id", referencedColumnName = "id")
    private List<Contact> contacts;
    private String details;
}
