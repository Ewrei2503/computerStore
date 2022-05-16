package com.example.computerStock.domain.pcComponents;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Product {
    @Id
    @Cascade(org.hibernate.annotations.CascadeType.ALL)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String company;
    private String model;
    private String type;
    private Integer num;


    public Product() {
    }

    public Product(String company, String model, String type) {
        this.company = company;
        this.model = model;
        this.type = type;
        num = 0;
    }

    public Product(Product prod) {
        this.id = prod.getId();
        this.company = prod.getCompany();
        this.model = prod.getModel();
        this.type = prod.getType();
        num = 0;
    }




    public Boolean isVideocard(){
        return type.equals("videocard");
    }
    public Boolean isProcessor(){
        return type.equals("processor");
    }
    public Boolean isRam(){
        return type.equals("ram");
    }
    public Boolean isMotherboard(){
        return type.equals("motherboard");
    }
    public Boolean isDrive(){
        return type.equals("drive");
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getCompany() {
        return company;
    }
    public void setCompany(String company) {
        this.company = company;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public Integer getNum() {
        return num;
    }
    public void setNum(Integer num) {
        this.num = num;
    }

}
