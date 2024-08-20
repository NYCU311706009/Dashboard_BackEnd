package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Description;
import com.example.demo.Repository.DescriptionRepository;

@Service
public class DescriptionService {
    @Autowired
    DescriptionRepository descriptionRepository;

    public Iterable<Description> getDescription(){
        return descriptionRepository.findAll();
    }
}
