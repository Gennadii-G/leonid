package com.spacefox.frida.rest.controllers;

import com.spacefox.frida.domain.DTO.TrampolineDTO;
import com.spacefox.frida.domain.Trampoline;
import com.spacefox.frida.services.TrampolineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TrampolineController {

    @Autowired
    private TrampolineService trampolineService;

    @GetMapping("/trampolines")
    public List<Trampoline> getAllTramps(){
        return trampolineService.getAll();
    }

    @GetMapping("/trampoline/{id}")
    public TrampolineDTO getTramp(@PathVariable long id){
        return trampolineService.convert(trampolineService.getById(id));
    }

    @PostMapping("trampoline/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTrampoline(@RequestBody @Valid TrampolineDTO trampDTO){
        trampolineService.save(trampDTO);
    }

    @PutMapping("trampoline/update")
    @ResponseStatus(HttpStatus.OK)
    public void updateTramp(@RequestBody @Valid TrampolineDTO trampDTO){
        trampolineService.update(trampolineService.convert(trampDTO));
    }

    @DeleteMapping("trampoline/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTramp(TrampolineDTO trampDTO){
        trampolineService.delete(trampolineService.convert(trampDTO));
    }

    @DeleteMapping("trampoline/delete/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTramp(@PathVariable Long id){
        trampolineService.delete(id);
    }
}
