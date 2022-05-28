package com.example.demo.dto;

import com.example.demo.entity.Inventory;
import com.example.demo.entity.RetailOrder;

public class ManufactureOrderDto {
    private Inventory inventory;
    private String retailername;
    private boolean shipment;
    private RetailOrder retailOrder;

    public ManufactureOrderDto() {
    }

    public ManufactureOrderDto(Inventory inventory, String retailername, boolean shipment, RetailOrder retailOrder) {
        this.inventory = inventory;
        this.retailername = retailername;
        this.shipment = shipment;
        this.retailOrder = retailOrder;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public String getRetailername() {
        return retailername;
    }

    public void setRetailername(String retailername) {
        this.retailername = retailername;
    }

    public boolean isShipment() {
        return shipment;
    }

    public void setShipment(boolean shipment) {
        this.shipment = shipment;
    }

    public RetailOrder getRetailOrder() {
        return retailOrder;
    }

    public void setRetailOrder(RetailOrder retailOrder) {
        this.retailOrder = retailOrder;
    }

    @Override
    public String toString() {
        return "ManufactureOrderDto{" +
                "inventory=" + inventory +
                ", retailername='" + retailername + '\'' +
                ", shipment=" + shipment +
                ", retailOrder=" + retailOrder +
                '}';
    }
}
