package com.example.lima.model;

public class Customer {
    protected Integer id;
    protected String email;
    protected String nif;
    protected String address;
    protected String name;
    protected String customerType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }
    
    public Customer() {}

    public Customer(String email, String nif, String address, String name, String customerType) {
        this.email = email;
        this.nif = nif;
        this.address = address;
        this.name = name;
        this.customerType = customerType;
    }
}
