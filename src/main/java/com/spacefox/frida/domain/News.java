package com.spacefox.frida.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity(name="jh_news")
@Getter @Setter @NoArgsConstructor
@ToString
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String picture;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private String body;
    @Column(nullable = false)
    private Date createdDate;
    private Date publicationDate;

}
