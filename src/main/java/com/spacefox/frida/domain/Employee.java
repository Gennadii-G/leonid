package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="jh_employee")
@Getter @Setter @NoArgsConstructor
public class Employee extends DomainObject  {

//    @ManyToMany(cascade = CascadeType.ALL)
//    @JoinTable()
    private Contact contact;
    private String details;

}
