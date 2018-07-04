package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.TrampolineHallDTO;
import com.spacefox.frida.domain.TrampolineHall;
import com.spacefox.frida.services.TrampolineHallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrampolineHallController {

    @Autowired
    private TrampolineHallService hallService;

    @GetMapping("/trampolineHalls")
    @ResponseStatus(HttpStatus.OK)
    public List<TrampolineHallDTO> getAllHalls() {
        List<TrampolineHall> halls = hallService.getAll();
        return hallService.getDTO(halls);
    }

    @PostMapping("trampolineHall/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrampHall(TrampolineHallDTO hallDTO){
        hallService.createTrampolineHall(hallDTO);
    }

    @PutMapping("trampolineHall/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTrampHall(TrampolineHallDTO hallDTO){
        hallService.update(hallDTO);
    }

    @DeleteMapping("trampolineHall/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrampHall(TrampolineHallDTO hallDTO){
        hallService.delete(hallDTO);
    }
}