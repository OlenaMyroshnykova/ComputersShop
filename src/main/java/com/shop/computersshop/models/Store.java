package com.shop.computersshop.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Store {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String taxId;

    @ManyToOne
    @JoinColumn(name = "owner_id", nullable = false)
    private StoreOwner owner;

    @OneToMany(mappedBy = "store", cascade = CascadeType.ALL)
    private List<Computer> computers;
    
    public Store() {
    }
    
    public Store(Long id, String name, String taxId, StoreOwner owner) {
        this.id = id;
        this.name = name;
        this.taxId = taxId;
        this.owner = owner;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }

    public StoreOwner getOwner() {
        return owner;
    }

    public void setOwner(StoreOwner owner) {
        this.owner = owner;
    }
}
