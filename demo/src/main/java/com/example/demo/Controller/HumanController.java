package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Human;
import com.example.demo.Service.HumanService;

@RestController
public class HumanController {
    @Autowired
    HumanService humanService;
    @GetMapping("/human")
    public Iterable<Human> getAllHuman(){
        return humanService.getAllHuman();
    }

    @GetMapping("/human/{id}")
    public Optional<Human> getHumanById(@PathVariable Long id){
        return humanService.getHumanById(id);
    }
}
