package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Human;
import com.example.demo.Repository.HumanRepository;

@Service
public class HumanService {
    @Autowired
    HumanRepository humanRepository;
    public Iterable<Human> getAllHuman(){
        return humanRepository.findAll();
    }
    public Optional<Human> getHumanById(Long id){
        return humanRepository.findById(id);
    }
}
