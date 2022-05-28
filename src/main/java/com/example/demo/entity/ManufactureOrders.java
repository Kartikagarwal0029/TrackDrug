package com.example.demo.entity;

import com.example.demo.audit.Auditable;

import javax.persistence.*;

@Entity
public class ManufactureOrders extends Auditable<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String manufacturename;
    private boolean shipment;
    private boolean accept;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "retail_order_id", referencedColumnName = "id")
    private RetailOrder retailOrder;

    @OneToOne(mappedBy = "manufactureOrders",cascade = CascadeType.ALL)
    private ShipmentOrder shipmentOrder;

    public ManufactureOrders() {
    }

    public ManufactureOrders(int id, String manufacturename, boolean shipment, boolean accept, RetailOrder retailOrder) {
        this.id = id;
        this.manufacturename = manufacturename;
        this.shipment = shipment;
        this.accept = accept;
        this.retailOrder = retailOrder;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getManufacturename() {
        return manufacturename;
    }

    public void setManufacturename(String manufacturename) {
        this.manufacturename = manufacturename;
    }

    public boolean isShipment() {
        return shipment;
    }

    public void setShipment(boolean shipment) {
        this.shipment = shipment;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public RetailOrder getRetailOrder() {
        return retailOrder;
    }

    public void setRetailOrder(RetailOrder retailOrder) {
        this.retailOrder = retailOrder;
    }

    public ShipmentOrder getShipmentOrder() {
        return shipmentOrder;
    }

    public void setShipmentOrder(ShipmentOrder shipmentOrder) {
        this.shipmentOrder = shipmentOrder;
    }

    @Override
    public String toString() {
        return "ManufactureOrders{" +
                "id=" + id +
                ", manufacturename='" + manufacturename + '\'' +
                ", shipment=" + shipment +
                ", accept=" + accept +
                ", retailOrder=" + retailOrder +
                '}';
    }
}

