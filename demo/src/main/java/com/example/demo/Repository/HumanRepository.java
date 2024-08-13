package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Machine;

@Repository
public interface HumanRepository extends CrudRepository<Machine, Long>{
    Optional<Machine> findById(Long id);
} 