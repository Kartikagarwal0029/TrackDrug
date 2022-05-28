package com.example.demo.dto;

import com.example.demo.entity.Inventory;

public class RetailOrderDto {
    private int quantity;
    private boolean accepted;
    private String name;
    private Inventory inventory;

    public RetailOrderDto() {
    }

    public RetailOrderDto(int quantity, boolean accepted, String name, Inventory inventory) {
        this.quantity = quantity;
        this.accepted = accepted;
        this.name = name;
        this.inventory = inventory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    @Override
    public String toString() {
        return "RetailOrderDto{" +
                "quantity=" + quantity +
                ", accepted=" + accepted +
                ", name='" + name + '\'' +
                ", inventory=" + inventory +
                '}';
    }
}
