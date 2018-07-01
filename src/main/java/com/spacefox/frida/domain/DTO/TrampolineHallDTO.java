package com.spacefox.frida.domain.DTO;

import com.spacefox.frida.domain.Order;
import com.spacefox.frida.domain.Trampoline;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @Getter
@Setter
public class TrampolineHallDTO {

    private List<Order> orders;
    private List<Trampoline> trampolines = new ArrayList<>();
    private int price;
    private String name;
    private String address;
    private String phone;
    private int trampsAmount;
}
