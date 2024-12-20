package com.shop.computersshop.models;

import jakarta.persistence.*;

@Entity
public class Computer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    private int memory;
    private String processor;
    private String operatingSystem;
    private double price;

    @ManyToOne
    @JoinColumn(name = "store_id", nullable = false)
    private Store store;


    public Computer(Long id, Brand brand, int memory, String processor, String operatingSystem, double price,
            Store store) {
        this.id = id;
        this.memory = memory;
        this.processor = processor;
        this.operatingSystem = operatingSystem;
        this.price = price;
        this.store = store;
        this.brand = brand;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Store getStore() {
        return store;
    }

    public void setStore(Store store) {
        this.store = store;
    }

}
