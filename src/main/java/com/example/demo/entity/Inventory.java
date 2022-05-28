package com.example.demo.entity;

import com.example.demo.audit.Auditable;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Set;

@Entity
public class Inventory extends Auditable<String> {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    @NotNull
    @Column(nullable = false)
    private String productName;
    @NotNull
    @Column(nullable = false)
    private String serialNo;
    private String manufactureDate;
    private String expiryDate;
    @NotNull
    @Column(nullable = false)
    private int boxes;
    @NotNull
    @Column(nullable = false)
    private String stripPerBox;
    @NotNull
    @Column(nullable = false)
    private String pricePerBox;

    @ManyToOne(cascade = CascadeType.ALL)
    private User user;

    @OneToMany(cascade = CascadeType.ALL)
    private Set<RetailOrder> retailOrders;

    public Inventory() {
    }

    public Inventory(int id, String productName, String serialNo, String manufactureDate, String expiryDate, int boxes, String stripPerBox, String pricePerBox, User user, Set<RetailOrder> retailOrders) {
        this.id = id;
        this.productName = productName;
        this.serialNo = serialNo;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.boxes = boxes;
        this.stripPerBox = stripPerBox;
        this.pricePerBox = pricePerBox;
        this.user = user;
        this.retailOrders = retailOrders;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getSerialNo() {
        return serialNo;
    }

    public void setSerialNo(String serialNo) {
        this.serialNo = serialNo;
    }

    public String getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public int getBoxes() {
        return boxes;
    }

    public void setBoxes(int boxes) {
        this.boxes = boxes;
    }

    public String getStripPerBox() {
        return stripPerBox;
    }

    public void setStripPerBox(String stripPerBox) {
        this.stripPerBox = stripPerBox;
    }

    public String getPricePerBox() {
        return pricePerBox;
    }

    public void setPricePerBox(String pricePerBox) {
        this.pricePerBox = pricePerBox;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<RetailOrder> getRetailOrders() {
        return retailOrders;
    }

    public void setRetailOrders(Set<RetailOrder> retailOrders) {
        this.retailOrders = retailOrders;
    }

    @Override
    public String toString() {
        return "Inventory{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", boxes=" + boxes +
                ", stripPerBox='" + stripPerBox + '\'' +
                ", pricePerBox='" + pricePerBox + '\'' +
                ", user=" + user +
                ", retailOrders=" + retailOrders +
                '}';
    }
}
