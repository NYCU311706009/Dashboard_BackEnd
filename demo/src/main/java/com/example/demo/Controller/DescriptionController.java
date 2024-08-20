package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Description;
import com.example.demo.Service.DescriptionService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class DescriptionController {
    @Autowired
    DescriptionService descriptionService;

    @GetMapping("description")
    public Iterable<Description> getDescription(){
        return descriptionService.getDescription();
    }
}
