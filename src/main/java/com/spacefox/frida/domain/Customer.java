package com.spacefox.frida.domain;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="jh_customer")
public class Customer extends DomainObject {

    @OneToOne
    @JoinColumn(name="contact_id")
    private Contact contact;
    //    private Role role;
    private String details;

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
