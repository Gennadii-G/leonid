package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jh_customer")
@Getter @Setter @NoArgsConstructor
public class Customer extends DomainObject {

    @OneToOne
    @JoinColumn(name="contact_id")
    private Contact contact;
    private String details;


}
