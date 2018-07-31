package com.spacefox.frida.domain;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="jh_picture")
@Data
public class PictureJH {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String key;
    private String filename;
    private Long size;
    private LocalDateTime whenSaved;

}
