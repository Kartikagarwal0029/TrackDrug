package com.example.demo.dto;

public class InventoryDto {
    private int id;
    private String productName;
    private String serialNo;
    private String manufactureDate;
    private String expiryDate;
    private int boxes;
    private String stripPerBox;
    private String pricePerBox;

    public InventoryDto() {
    }

    public InventoryDto(int id, String productName, String serialNo, String manufactureDate, String expiryDate, int boxes, String stripPerBox, String pricePerBox) {
        this.id = id;
        this.productName = productName;
        this.serialNo = serialNo;
        this.manufactureDate = manufactureDate;
        this.expiryDate = expiryDate;
        this.boxes = boxes;
        this.stripPerBox = stripPerBox;
        this.pricePerBox = pricePerBox;
    }

    public int getId() {
        return id;
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

    @Override
    public String toString() {
        return "InventoryDto{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", serialNo='" + serialNo + '\'' +
                ", manufactureDate='" + manufactureDate + '\'' +
                ", expiryDate='" + expiryDate + '\'' +
                ", boxes='" + boxes + '\'' +
                ", stripPerBox='" + stripPerBox + '\'' +
                ", pricePerBox='" + pricePerBox + '\'' +
                '}';
    }
}
