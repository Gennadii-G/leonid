package com.spacefox.frida.rest.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;

@Getter @Setter
@ToString
public class NewsDTO {

    private String picture;
    private String title;
    private String body;
    private Date createdDate;
    private Date publicationDate;
}
