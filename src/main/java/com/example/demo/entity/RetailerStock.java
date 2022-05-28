package com.example.demo.entity;

import javax.persistence.*;

@Entity
public class RetailerStock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private String retailername;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "retail_order_id", referencedColumnName = "id")
    private RetailOrder retailOrder;

    public RetailerStock() {
    }

    public RetailerStock(int id, int quantity, String retailername, RetailOrder retailOrder) {
        this.id = id;
        this.quantity = quantity;
        this.retailername = retailername;
        this.retailOrder = retailOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getRetailername() {
        return retailername;
    }

    public void setRetailername(String retailername) {
        this.retailername = retailername;
    }

    public RetailOrder getRetailOrder() {
        return retailOrder;
    }

    public void setRetailOrder(RetailOrder retailOrder) {
        this.retailOrder = retailOrder;
    }

    @Override
    public String toString() {
        return "RetailerStock{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", retailername='" + retailername + '\'' +
                ", retailOrder=" + retailOrder +
                '}';
    }
}
