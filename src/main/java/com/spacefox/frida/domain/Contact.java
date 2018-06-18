package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="jh_contact")
@Getter @Setter @NoArgsConstructor
public class Contact extends DomainObject {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String Address;
    @NotNull
    @Min(18)
    private int age;

}
