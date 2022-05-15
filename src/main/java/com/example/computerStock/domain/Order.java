package com.example.computerStock.domain;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User executor;
    private Boolean type;
    private Boolean wait;

    public Order() {
    }

    public Order(User executor, Boolean type, Boolean wait) {
        this.executor = executor;
        this.type = type;
        this.wait = wait;
    }

    public Order(Boolean type) {
        this.type = type;
        this.wait = true;
        this.executor = null;
    }

    public User getExecutor() {
        return executor;
    }

    public void setExecutor(User executor) {
        this.executor = executor;
    }

    public Boolean getType() {
        return type;
    }

    public void setType(Boolean type) {
        this.type = type;
    }

    public Boolean getWait() {
        return wait;
    }

    public void setWait(Boolean wait) {
        this.wait = wait;
    }

    public Long getId() {
        return id;
    }
}
