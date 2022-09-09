package com.example.lima.dao.impl;


import com.example.lima.dao.OrderDao;
import com.example.lima.factory.OrderFactory;
import com.example.lima.model.Order;
import com.example.lima.util.DBConnection;
import com.example.lima.constant.QueryConstant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderDaoImpl implements OrderDao {
    private DBConnection database = DBConnection.getInstance();

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        database.connect();
        try{
            //PreparedStatement statement = database.connection.prepareStatement("SELECT * FROM lima.order");
            CallableStatement statement = database.connection.prepareCall("CALL read_all_order()");
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Order order = OrderFactory.getOrder();
                order.setId(result.getInt("id"));
                order.setItemId(result.getInt("item_id"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setOrderDate(result.getDate("order_date"));
                order.setReadyToShip(result.getBoolean("ready_to_ship"));
                order.setUnits(result.getInt("units"));
                orders.add(order);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return orders;
    }

    @Override
    public void saveOrder(Order order) {
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ORDER_CREATE);
            statement.setInt(1, order.getItemId());
            statement.setInt(2, order.getCustomerId());
            statement.setObject(3, order.getOrderDate());
            statement.setBoolean(4, order.isReadyToShip());
            statement.setInt(5, order.getUnits());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
    }

    @Override
    public void deleteOrder(Order order) {
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ORDER_DELETE);
            statement.setInt(1, order.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
    }

    @Override
    public Order getOrderById(int id) {
        Order order = OrderFactory.getOrder();
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ORDER_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while(result.next()) {
                order.setId(result.getInt("id"));
                order.setItemId(result.getInt("item_id"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setOrderDate(result.getDate("order_date"));
                order.setReadyToShip(result.getBoolean("ready_to_ship"));
                order.setUnits(result.getInt("units"));
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return order;
    }

    @Override
    public ObservableList<Order> orderIsSend(boolean isFiltered) {
        //List<Order> orders = new ArrayList<>();
        ObservableList orders = FXCollections.observableArrayList();
        database.connect();
        try{
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ORDER_IS_SEND);
            statement.setBoolean(1, isFiltered);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Order order = OrderFactory.getOrder();
                order.setId(result.getInt("id"));
                order.setItemId(result.getInt("item_id"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setOrderDate(result.getDate("order_date"));
                order.setReadyToShip(result.getBoolean("ready_to_ship"));
                order.setUnits(result.getInt("units"));
                orders.add(order);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return orders;
    }

    @Override
    public List<Order> orderIsSendFiltered(String nif, boolean isReadyToShip) {
        List<Order> orders = new ArrayList<>();
        database.connect();
        try{
            //PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ORDER_IS_SEND_FILTERED);
            CallableStatement statement = database.connection.prepareCall("CALL order_is_send_filtered(?, ?)");
            System.out.println("Nif: " + nif + ". Esta readyToShip? " + isReadyToShip);
            statement.setString(1, nif);
            statement.setBoolean(2, isReadyToShip);
            ResultSet result = statement.executeQuery();
            while(result.next()){
                Order order = OrderFactory.getOrder();
                order.setId(result.getInt("id"));
                order.setItemId(result.getInt("item_id"));
                order.setCustomerId(result.getInt("customer_id"));
                order.setOrderDate(result.getDate("order_date"));
                order.setReadyToShip(result.getBoolean("ready_to_ship"));
                order.setUnits(result.getInt("units"));
                orders.add(order);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return orders;
    }
}