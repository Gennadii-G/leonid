package com.spacefox.frida.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;

@Entity(name="jh_news")
@Getter @Setter @NoArgsConstructor
public class News extends DomainObject {



    private PictureJH picture;

}
