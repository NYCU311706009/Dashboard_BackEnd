package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Human;

@Repository
public interface HumanRepository extends CrudRepository<Human, Long>{
    Optional<Human> findById(Long id);
} 