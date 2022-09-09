package com.example.lima.factory;

import com.example.lima.dao.impl.CustomerDaoImpl;
import com.example.lima.model.Customer;
import com.example.lima.model.Premium;
import com.example.lima.model.Standard;

public class CustomerFactory {

    public static Customer getCustomer() { return new Customer();}

    public static Customer getCustomerPremium(){ return new Premium(); }

    public static Customer getCustomerStandard(){ return new Standard(); }

    public static CustomerDaoImpl getCustomerDaoImpl(){
        return new CustomerDaoImpl();
    }

    /*public static CustomerController getCustomerController(){
        return new CustomerController();
    }
    public static CustomerView getCustomerView(){
        return new CustomerView();
    }*/

}
