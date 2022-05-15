package com.example.computerStock.domain;

import com.example.computerStock.domain.pcComponents.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sold implements Serializable {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    private Boolean warranty;
}