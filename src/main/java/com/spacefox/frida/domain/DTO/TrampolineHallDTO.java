package com.spacefox.frida.domain.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter
@Setter
public class TrampolineHallDTO {

    private int price;
    private String name;
    private String address;
    private String phone;
    private int trampsAmount;
}
