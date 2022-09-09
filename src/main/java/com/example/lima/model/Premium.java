package com.example.lima.model;

public class Premium extends Customer {
    private Integer annualQuota = 30;
    private double discount = 0.20;

    public Integer getAnnualQuota() {
        return annualQuota;
    }

    public void AnnualQuota(Integer annualQuota) {
        this.annualQuota = annualQuota;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public Premium() {}

    public Premium(String email, String nif, String address, String name, String customerType) {
        super(email, nif, address, name, customerType);
    }
    
    // Metodos abstractos
    public String customerType() {
        return "Premium";
    }
    
    public float annualCalc() {
        return annualQuota;
    }
    
    /* public double shippingDiscount(Item item) {
        return discount * item.getSellPrice();
    } */

    @Override
    public String toString() {
        return "id=" + getId() + ", email=" + getEmail() + ", nif=" + getNif()
                + ", address=" + getAddress() + ", name=" + getName() + ", customerType=" + getCustomerType();
    }
}