package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.MachineRecord;



@Repository
public interface RecordRepository extends CrudRepository<MachineRecord, Long>{
    Optional<MachineRecord> findById(Long id);

}
