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

    @GetMapping("/trampolineHalls")
    @ResponseStatus(HttpStatus.OK)
    public List<TrampolineHallDTO> getAllHalls() {
        List<TrampolineHall> halls = hallService.getAll();
        return hallService.convert(halls);
    }

    @GetMapping("/trampolineHall/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TrampolineHallDTO getHall(@PathVariable Long id) {
        return hallService.convert(hallService.getById(id));
    }

    @PostMapping("trampolineHall/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrampHall(@RequestBody @Valid TrampolineHallDTO hallDTO){
        hallService.createTrampolineHall(hallDTO);
    }

    @PutMapping("trampolineHall/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTrampHall(@RequestBody @Valid TrampolineHallDTO hallDTO){
        hallService.update(hallDTO);
    }

    @DeleteMapping("trampolineHall/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrampHall(@Valid TrampolineHallDTO hallDTO){
        hallService.delete(hallDTO);
    }

    @PostMapping("trampolineHall/tramps/add")
    @ResponseStatus(HttpStatus.OK)
    public void addTramps(@RequestBody @Valid IdentifierDTO dto){
        hallService.addTrampsById(dto.getTargetId(), dto.getIdentifiers());
    }
}
