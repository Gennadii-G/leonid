package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.services.TrampolineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrampolineController {

    @Autowired
    private TrampolineService trampolineService;

    @GetMapping("/trampolines")
    public List<Trampoline> getAllTramps(){
        return trampolineService.getAll();
    }

    @GetMapping("/trampolines/{id}")
    public Trampoline getAllTramps(@PathVariable long id){
        return trampolineService.getById(id);
    }

    @PostMapping("trampoline/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrampoline(TrampolineDTO trampDTO){
        trampolineService.save(trampDTO);
    }

    @PutMapping("trampoline/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTrampHall(TrampolineDTO trampDTO){
        trampolineService.update(trampDTO);
    }

    @DeleteMapping("trampoline/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrampHall(TrampolineDTO trampDTO){
        trampolineService.delete(trampDTO);
    }
}
