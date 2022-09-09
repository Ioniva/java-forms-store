package com.example.lima.factory;

import com.example.lima.dao.impl.OrderDaoImpl;
import com.example.lima.model.Order;

public class OrderFactory {
    public static Order getOrder() { return new Order();}

    public static OrderDaoImpl getOrderDao(){
        return new OrderDaoImpl();
    }
}
