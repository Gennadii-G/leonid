package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="jh_customer")
@Getter @Setter @NoArgsConstructor
public class Customer extends DomainObject {

    private Contact contact;
    private String details;


}
