package com.example.computerStock.domain;

import com.example.computerStock.domain.pcComponents.Product;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Sold{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Sold() {
    }

    public Sold(Position position, Product product) {
        this.product = product;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getId() {
        return id;
    }
}