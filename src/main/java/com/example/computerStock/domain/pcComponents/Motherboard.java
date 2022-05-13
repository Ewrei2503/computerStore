package com.example.computerStock.domain.pcComponents;

import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;

@Entity
@PrimaryKeyJoinColumn(name = "product_id")
public class Motherboard extends Product{

    private String socket;
    public Motherboard(String company, String model, String type, String socket) {
        super(company, model, type);
        this.socket = socket;
    }

    public Motherboard() {
    }

    public String getSocket() {
        return socket;
    }

    public void setSocket(String socket) {
        this.socket = socket;
    }
}
