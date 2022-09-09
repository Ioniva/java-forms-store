package com.example.lima.model;

public class Standard extends Customer {
    public Standard() {}

    public Standard(String email, String nif, String address, String name, String customerType) {
        super(email, nif, address, name, customerType);
    }

    // Metodos abstractos
    
    public String customerType() {
        return "Estandar";
    }
    
    public float annualCalc() {
        return 0;
    }
    
    /* public double shippingDiscount(Item item) {
        return 0;
    } */

    @Override
    public String toString() {
       return "id=" + getId() + ", email=" + getEmail() + ", nif=" + getNif()
           + ", address=" + getAddress() + ", name=" + getName() + ", customerType=" + getCustomerType();
    }
}
