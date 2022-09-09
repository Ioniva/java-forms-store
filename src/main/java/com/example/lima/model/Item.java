package com.example.lima.model;

public class Item {
    private int id;
    private String code;
    private String description;
    private double sellPrice;
    private double itemshippingCost;
    private int preparationTime;

    public Item() {}

    public Item(String code, String description, double sellPrice, double itemshippingCost, int preparationTime) {
        this.code = code;
        this.description = description;
        this.sellPrice = sellPrice;
        this.itemshippingCost = itemshippingCost;
        this.preparationTime = preparationTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public double getItemshippingCost() {
        return itemshippingCost;
    }

    public void setItemshippingCost(double itemshippingCost) {
        this.itemshippingCost = itemshippingCost;
    }

    public int getPreparationTime() {
        return preparationTime;
    }

    public void setPreparationTime(int preparationTime) {
        this.preparationTime = preparationTime;
    }
}
