package com.example.demo.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Data
@Entity
public class Description {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "dicription_seq")
    @SequenceGenerator(name="dicription_seq", sequenceName = "dicription_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    private String note;
    Description(){

    }
}
