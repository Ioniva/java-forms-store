package com.example.lima.model;

import java.util.Date;

public class Order {
    private int id;
    private int units;
    private Date orderDate;
    private int customerId;
    private int itemId;
    private boolean readyToShip;

    public Order(){}
    public Order(int units, Date orderDate, int customer, int item, boolean readyToShip) {
        this.units = units;
        this.orderDate = orderDate;
        this.customerId = customer;
        this.itemId = item;
        this.readyToShip = readyToShip;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUnits() {
        return units;
    }

    public void setUnits(int units) {
        this.units = units;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public boolean isReadyToShip() {
        return readyToShip;
    }

    public void setReadyToShip(boolean readyToShip) {
        this.readyToShip = readyToShip;
    }
}
