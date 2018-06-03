package com.spacefox.frida.domain;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
public class DomainObject implements Serializable {

    public DomainObject() {
    }

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long publicid;

    public Long getPublicId() {
        return publicid;
    }

    public void setPublicId(Long publicId) {
        this.publicid = publicId;
    }
}
