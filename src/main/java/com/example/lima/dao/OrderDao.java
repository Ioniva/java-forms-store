package com.example.lima.dao;

import java.util.List;

import com.example.lima.model.Order;
import javafx.collections.ObservableList;

public interface OrderDao {
    List<Order> getAllOrders();
    void saveOrder(Order order);
    void deleteOrder(Order order);
    Order getOrderById(int id);
    List<Order> orderIsSendFiltered(String nif, boolean isReadyToShip);
    ObservableList<Order> orderIsSend(boolean isReadyToShip);
}
