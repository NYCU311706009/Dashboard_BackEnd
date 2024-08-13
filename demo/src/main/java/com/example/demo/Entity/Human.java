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
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq")
    @SequenceGenerator(name="machine_seq", sequenceName = "machine_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    public enum Department {
        PRODUCTION, // 生產單位
        EQUIPMENT, // 設備單位
        TESTING, // 測試單位
        ENGINEER // 工程單位
    }

    public enum Area {
        A,
        B,
        C,
        D
    }
    @Enumerated(EnumType.STRING)
    private Department department;

    @Enumerated(EnumType.STRING)
    private Area currentArea;

    public Human(){
        this.department = Department.PRODUCTION;
        this.currentArea = Area.A;
    }

    public void setToAreaA() {
        this.currentArea = Area.A;
    }

    public void setToAreaB() {
        this.currentArea = Area.B;
    }

    public void setToAreaC() {
        this.currentArea = Area.C;
    }

    public void setToAreaD() {
        this.currentArea = Area.D;
    }

}
