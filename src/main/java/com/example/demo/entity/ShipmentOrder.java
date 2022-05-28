package com.example.demo.entity;

import com.example.demo.audit.Auditable;

import javax.persistence.*;

@Entity
public class ShipmentOrder extends Auditable<String> {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;
    private String manufacturename;
    private String retailername;
    private boolean accept;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "manufacture_orders_id" , referencedColumnName = "id")
    private ManufactureOrders manufactureOrders;


    public ShipmentOrder() {
    }

    public ShipmentOrder(int id, String manufacturename, String retailername, boolean accept, ManufactureOrders manufactureOrders) {
        this.id = id;
        this.manufacturename = manufacturename;
        this.retailername = retailername;
        this.accept = accept;
        this.manufactureOrders = manufactureOrders;
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

    public String getRetailername() {
        return retailername;
    }

    public void setRetailername(String retailername) {
        this.retailername = retailername;
    }

    public boolean isAccept() {
        return accept;
    }

    public void setAccept(boolean accept) {
        this.accept = accept;
    }

    public ManufactureOrders getManufactureOrders() {
        return manufactureOrders;
    }

    public void setManufactureOrders(ManufactureOrders manufactureOrders) {
        this.manufactureOrders = manufactureOrders;
    }

    @Override
    public String toString() {
        return "ShipmentOrder{" +
                "id=" + id +
                ", manufacturename='" + manufacturename + '\'' +
                ", retailername='" + retailername + '\'' +
                ", accept=" + accept +
                ", manufactureOrders=" + manufactureOrders +
                '}';
    }
}
