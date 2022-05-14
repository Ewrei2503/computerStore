package com.example.computerStock.domain.pcComponents;

import javax.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Processor extends Product{
    private Integer cores;
    private Integer thread;
    private Integer clock;

    public Processor() {
    }

    public Processor(String company, String model, String type, Integer cores, Integer thread, Integer clock) {
        super(company, model, type);
        this.cores = cores;
        this.thread = thread;
        this.clock = clock;
    }

    public Processor(Product prod, Integer cores, Integer thread, Integer clock) {
        super(prod);
        this.cores = cores;
        this.thread = thread;
        this.clock = clock;
    }

    public Integer getCores() {
        return cores;
    }

    public void setCores(Integer cores) {
        this.cores = cores;
    }

    public Integer getThread() {
        return thread;
    }

    public void setThread(Integer thread) {
        this.thread = thread;
    }

    public Integer getClock() {
        return clock;
    }

    public void setClock(Integer clock) {
        this.clock = clock;
    }
}
