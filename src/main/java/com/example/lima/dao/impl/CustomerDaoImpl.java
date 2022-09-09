package com.example.lima.dao.impl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.lima.dao.CustomerDao;
import com.example.lima.factory.CustomerFactory;
import com.example.lima.model.Customer;
import com.example.lima.util.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.example.lima.constant.QueryConstant;

public class CustomerDaoImpl implements CustomerDao {
    private DBConnection database = DBConnection.getInstance();

    @Override
    public List<Customer> getAllCustomers() {
        List<Customer> customers = new ArrayList<>();
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_CUSTOMER_GET_ALL);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if (result.getString("customer_type").equals("Premium")) {
                    Customer customer = CustomerFactory.getCustomerPremium();
                    customer.setCustomerType(result.getString("customer_type"));
                    customer.setId(result.getInt("id"));
                    customer.setName(result.getString("name"));
                    customer.setNif(result.getString("nif"));
                    customer.setAddress(result.getString("address"));
                    customer.setEmail(result.getString("email"));
                    customers.add(customer);
                }

                if (result.getString("customer_type").equals("Estandar")) {
                    Customer customer = CustomerFactory.getCustomerStandard();
                    customer.setCustomerType(result.getString("customer_type"));
                    customer.setId(result.getInt("id"));
                    customer.setName(result.getString("name"));
                    customer.setNif(result.getString("nif"));
                    customer.setAddress(result.getString("address"));
                    customer.setEmail(result.getString("email"));
                    customers.add(customer);
                }
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return customers;
    }

    @Override
    public int saveCustomer(Customer customer) {
        int customerId = 0;
        database.connect();
        try {
            // PreparedStatement statement = database.connection.prepareStatement("INSERT INTO lima.customer (name, nif, address, email, customer_type) VALUES (QueryConstant.QUERY_CUSTOMER_CREATE);
            CallableStatement statement = database.connection.prepareCall("CALL create_customer(?, ?, ?, ?, ?, ?)");
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getNif());
            statement.setString(3, customer.getAddress());
            statement.setString(4, customer.getEmail());
            statement.setString(5, customer.getCustomerType());
            statement.registerOutParameter("Id", Types.INTEGER);
            statement.executeUpdate();

            customerId = statement.getInt("Id");

            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return customerId;
    }

    @Override
    public ObservableList<Customer> getAllCustomersByType(String type) {
        //List<Customer> customers = new ArrayList<>();
        ObservableList customers = FXCollections.observableArrayList();
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_CUSTOMER_GET_ALL_BY_TYPE);
            statement.setString(1, type);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if (result.getString("customer_type").equals("Premium")){
                    Customer customer = CustomerFactory.getCustomerPremium();
                    customer.setCustomerType(result.getString("customer_type"));
                    customer.setId(result.getInt("id"));
                    customer.setName(result.getString("name"));
                    customer.setNif(result.getString("nif"));
                    customer.setAddress(result.getString("address"));
                    customer.setEmail(result.getString("email"));
                    customers.add(customer);
                }

                if (result.getString("customer_type").equals("Estandar")) {
                    Customer customer = CustomerFactory.getCustomerStandard();
                    customer.setCustomerType(result.getString("customer_type"));
                    customer.setId(result.getInt("id"));
                    customer.setName(result.getString("name"));
                    customer.setNif(result.getString("nif"));
                    customer.setAddress(result.getString("address"));
                    customer.setEmail(result.getString("email"));
                    customers.add(customer);
                }
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return customers;
    }
    
    
    public Customer getCustomerByNif(String nif) {
        Customer customer = null;
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_CUSTOMER_GET_BY_NIF);
            statement.setString(1, nif);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                if (result.getString("customer_type").equals("Premium")){
                    customer = CustomerFactory.getCustomerPremium();
                    customer.setCustomerType(result.getString("customer_type"));
                }
                if (result.getString("customer_type").equals("Estandar")) {
                    customer = CustomerFactory.getCustomerStandard();
                    customer.setCustomerType(result.getString("customer_type"));
                }
                customer.setId(result.getInt("id"));
                customer.setName(result.getString("name"));
                customer.setNif(result.getString("nif"));
                customer.setAddress(result.getString("address"));
                customer.setEmail(result.getString("email"));
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return customer;
    }
}
