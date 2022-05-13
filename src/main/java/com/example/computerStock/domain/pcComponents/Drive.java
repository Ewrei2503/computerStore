package com.example.computerStock.domain.pcComponents;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Drive extends Product{
    private Integer memory;
    private Integer clock;
    private Boolean typeDrive;

    public Drive() {
        super();
    }

    public Drive(String company, String model, String type, Integer mem, Integer clock, Boolean type1) {
        super(company, model, type);
        this.memory = mem;
        this.clock = clock;
        this.typeDrive = typeDrive;
    }

    public Integer getMem() {
        return memory;
    }

    public void setMem(Integer mem) {
        this.memory = mem;
    }

    public Integer getClock() {
        return clock;
    }

    public void setClock(Integer clock) {
        this.clock = clock;
    }

    public Boolean getTypeDrive() {
        return typeDrive;
    }

    public void setTypeDrive(Boolean type) {
        this.typeDrive = type;
    }
}
