package com.example.demo.Entity;

import com.example.demo.Entity.Machine.Area;
import com.example.demo.Entity.Machine.Department;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.Data;

@Entity
@Data
public class Human {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "human_seq")
    @SequenceGenerator(name="human_seq", sequenceName = "human_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    public enum Department {
        PRODUCTION, // 生產單位
        EQUIPMENT, // 設備單位
        TESTING, // 測試單位
        ENGINEER // 工程單位
    }

    
    @Enumerated(EnumType.STRING)
    private Department department;

    

    public Human(){
        this.department = Department.PRODUCTION;
    }


}
