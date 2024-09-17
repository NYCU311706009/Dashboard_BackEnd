package com.example.demo.Controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.MachineRecord;
import com.example.demo.Service.RecordService;

@RestController
@CrossOrigin(origins = "http://localhost:5173")
public class RecordController {
    @Autowired
    RecordService recordService;
    
    @GetMapping("/record")
    public Iterable<MachineRecord> getAllRecord(){
        return recordService.getAllRecord();
    }

    @GetMapping("/record/{id}")
    public Optional<MachineRecord> getRecordById(@PathVariable Long id){
        return recordService.getRecordById(id);
    }
}
