package com.usa.misiontic23.masterclass5.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.usa.misiontic23.masterclass5.entity.Box;
import com.usa.misiontic23.masterclass5.services.BoxService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/Box")
public class BoxController {

    @Autowired
    private BoxService boxService;

    @GetMapping("/all")
    public List<Box> getAll(){
        return boxService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Box> getById(@PathVariable("id") int id){
        return boxService.getById(id);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Box save(@RequestBody Box c){
        return boxService.save(c);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Box update(@RequestBody Box c){
        return boxService.update(c);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id){
        return boxService.delete(id);
    }




}
