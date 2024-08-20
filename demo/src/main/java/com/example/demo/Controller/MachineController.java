package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Machine;
import com.example.demo.Service.MachineService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class MachineController {
    @Autowired
    private MachineService machineService;


    @GetMapping("/machine")
    public Iterable<Machine> getAllMachine(){
        return machineService.getAllMachine();
    }

    @GetMapping("/machine/{id}")
    public Optional<Machine> getMachineById(@PathVariable Long id){
        return machineService.getMachineById(id);
    }
}
