package com.example.demo.Entity;

import java.sql.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Entity
@Data
public class MachineRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "record_seq")
    @SequenceGenerator(name="record_seq", sequenceName = "record_sequence", initialValue = 1, allocationSize = 1)
    private Long id;
    
    @Temporal(TemporalType.DATE)
    private Date record_date;

    private int quantity;

    @ManyToOne
    @JoinColumn(name = "machine_id")
    @JsonBackReference
    private Machine machine;

    public MachineRecord() {}

    public MachineRecord(Date record_date, int quantity, Machine machine) {
        this.record_date = record_date;
        this.quantity = quantity;
        this.machine = machine;
    }
}
