package com.example.demo.entity;

import com.example.demo.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RetailOrder extends Auditable<String> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private int quantity;
    private boolean accepted;
    private boolean acceptshipment;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Inventory inventory;

    @OneToOne(mappedBy = "retailOrder",cascade = CascadeType.ALL)
    private ManufactureOrders manufactureOrders;

    @OneToOne(mappedBy = "retailOrder", cascade = CascadeType.ALL)
    private RetailerStock retailerStock;

    public RetailOrder() {
    }

    public RetailOrder(int id, int quantity,boolean accepted,boolean acceptshipment, String name, Inventory inventory, ManufactureOrders manufactureOrders, RetailerStock retailerStock) {
        this.id = id;
        this.quantity = quantity;
        this.accepted = accepted;
        this.acceptshipment=acceptshipment;
        this.name = name;
        this.inventory = inventory;
        this.manufactureOrders = manufactureOrders;
        this.retailerStock = retailerStock;
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

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isAcceptshipment() {
        return acceptshipment;
    }

    public void setAcceptshipment(boolean acceptshipment) {
        this.acceptshipment = acceptshipment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public ManufactureOrders getManufactureOrders() {
        return manufactureOrders;
    }

    public void setManufactureOrders(ManufactureOrders manufactureOrders) {
        this.manufactureOrders = manufactureOrders;
    }

    public RetailerStock getRetailerStock() {
        return retailerStock;
    }

    public void setRetailerStock(RetailerStock retailerStock) {
        this.retailerStock = retailerStock;
    }

    @Override
    public String toString() {
        return "RetailOrder{" +
                "id=" + id +
                ", quantity=" + quantity +
                ", accepted=" + accepted +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
