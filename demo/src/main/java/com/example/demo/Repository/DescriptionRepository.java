package com.example.demo.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Description;

@Repository
public interface DescriptionRepository extends CrudRepository<Description, Long>{
    Optional<Description> findById(long id); 
}
