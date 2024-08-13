package com.example.demo.Entity;

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
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "machine_seq")
    @SequenceGenerator(name="machine_seq", sequenceName = "machine_sequence", initialValue = 1, allocationSize = 1)
    private long id; // 0001、0002、...、0100

    public enum State {
        PRODUCTION,     //生產
        MALFUNCTION,    //當機
        MAINTENANCE,    //裝機
        IDLE            //閒置
    }
    public enum Department{
        PRODUCTION, // 生產單位
        EQUIPMENT,  // 設備單位
        TESTING,    // 測試單位
        ENGINEER    // 工程單位
    }
    
    public enum Area {
        A,
        B,
        C,
        D
    }
    @Enumerated(EnumType.STRING)
    private State currentState; //狀態  

    private int quantity;       //產量
    
    @Enumerated(EnumType.STRING)
    private Department currentDepartment;

    @Enumerated(EnumType.STRING)
    private Area currentArea;

    
    public Machine(){
        this.currentState = State.IDLE; // Default Value
        this.quantity = 0;
        this.currentDepartment = Department.EQUIPMENT;
        this.currentArea = Area.A;
    }


    public State getCurrentState() {
        return currentState;
    }
    public Department getCurrentDepartment(){
        return currentDepartment;
    }
    
    // 切換到生產狀態
    public void setToProduction() {
        this.currentState = State.PRODUCTION;
    }

    // 切換到當機狀態
    public void setToMalfunction() {
        this.currentState = State.MALFUNCTION;
       
    }

    // 切換到裝機狀態
    public void setToMaintenance() {
        this.currentState = State.MAINTENANCE;
       
    }

    // 切換到閒置狀態
    public void setToIdle() {
        this.currentState = State.IDLE;
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
