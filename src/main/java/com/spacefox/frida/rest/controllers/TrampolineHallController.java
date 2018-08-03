package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.IdentifierDTO;
import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TrampolineHallController {

    @Autowired
    private TrampolineHallService hallService;

    @GetMapping("/trampolinehalls")
    @ResponseStatus(HttpStatus.OK)
    public List<TrampolineHallDTO> getAllHalls() {
        List<TrampolineHall> halls = hallService.getAll();
        return hallService.convert(halls);
    }

    @GetMapping("/trampolinehall/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrampolineHallDTO getHall(@PathVariable Long id) {
        return hallService.convert(hallService.getById(id));
    }

    @PostMapping("trampolinehall/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrampHall(@RequestBody @Valid TrampolineHallDTO hallDTO){
        hallService.createTrampolineHall(hallDTO);
    }

    @PutMapping("trampolinehall/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTrampHall(@RequestBody @Valid TrampolineHallDTO hallDTO){
        hallService.update(hallDTO);
    }

    @DeleteMapping("trampolinehall/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrampHall(@Valid TrampolineHallDTO hallDTO){
        hallService.delete(hallDTO);
    }

    @GetMapping("/trampolinehall/profit/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Long getHallProfit(@PathVariable Long id) {
        return hallService.profit(id);
    }

//    profit
}
