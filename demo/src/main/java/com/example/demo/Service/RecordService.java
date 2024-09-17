package com.example.demo.Service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.MachineRecord;
import com.example.demo.Repository.RecordRepository;

@Service
public class RecordService {
    @Autowired
    RecordRepository recordRepository;

    public Iterable<MachineRecord> getAllRecord(){
        return recordRepository.findAll();
    }
    public Optional<MachineRecord> getRecordById(Long id){
        return recordRepository.findById(id);     
    }
}
