package com.example.lima.dao;

import java.util.List;

import com.example.lima.model.Customer;

import javafx.collections.ObservableList;

public interface CustomerDao {
    List<Customer> getAllCustomers();
    int saveCustomer(Customer customer);
    ObservableList<Customer> getAllCustomersByType(String type);
    Customer getCustomerByNif(String nif);
}
