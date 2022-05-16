package com.example.computerStock.domain.pcComponents;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Drive extends Product{
    private Integer memory;
    private Boolean typeDrive;

    public Drive() {
        super();
    }

    public Drive(String company, String model, String type, Integer memory, Boolean typeDrive) {
        super(company, model, type);
        this.memory = memory;
        this.typeDrive = typeDrive;
    }

    public Drive(Product prod, Integer memory, Boolean typeDrive) {
        super(prod);
        this.memory = memory;
        this.typeDrive = typeDrive;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer mem) {
        this.memory = mem;
    }

    public Boolean getTypeDrive() {
        return typeDrive;
    }

    public void setTypeDrive(Boolean type) {
        this.typeDrive = type;
    }
}
