package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Machine;
import com.example.demo.Repository.MachineRepository;

@Service
public class MachineService{
    @Autowired
    MachineRepository machineRepository;

    public Iterable<Machine> getAllMachine(){
        return machineRepository.findAll();
    }
    public Optional<Machine> getMachineById(Long id){
        return machineRepository.findById(id);
    }
}