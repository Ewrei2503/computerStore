package com.example.computerStock.domain.pcComponents;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Ram extends Product{
    private Integer memory;
    private Integer clock;

    public Ram() {
    }

    public Ram(String company, String model, String type, Integer memory, Integer clock, Double price) {
        super(company, model, type, price);
        this.memory = memory;
        this.clock = clock;
    }

    public Ram(Product prod, Integer memory, Integer clock) {
        super(prod);
        this.memory = memory;
        this.clock = clock;
    }

    public Integer getMemory() {
        return memory;
    }

    public void setMemory(Integer memory) {
        this.memory = memory;
    }

    public Integer getClock() {
        return clock;
    }

    public void setClock(Integer clock) {
        this.clock = clock;
    }
}
