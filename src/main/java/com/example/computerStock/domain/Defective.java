package com.example.computerStock.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="brak")
public class Defective implements Serializable {
    @Id
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sold_position_id", referencedColumnName = "position_id")
    private Sold sold;
    private Boolean byWarranty;
}
