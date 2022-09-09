package com.example.lima.dao.impl;


import com.example.lima.constant.QueryConstant;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.example.lima.factory.ItemFactory;
import com.example.lima.model.Item;
import com.example.lima.util.DBConnection;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import com.example.lima.dao.ItemDao;

public class ItemDaoImpl implements ItemDao {

    private DBConnection database = DBConnection.getInstance();

    @Override
    public ObservableList<Item> getAllItems() {
        ObservableList<Item> items = FXCollections.observableArrayList();
        database.connect();
        try {
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ITEM_GET_ALL);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                Item item = ItemFactory.getItem();
                item.setId(result.getInt("id"));
                item.setCode(result.getString("code"));
                item.setDescription(result.getString("description"));
                item.setSellPrice(result.getDouble("sell_price"));
                item.setItemshippingCost(result.getDouble("shipping_cost"));
                item.setPreparationTime(result.getInt("preparation_time"));
                items.add(item);
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return items;
    }

    @Override
    public void saveItem(Item item) {
        database.connect();
        try {
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ITEM_CREATE);
            statement.setString(1, item.getCode());
            statement.setString(2, item.getDescription());
            statement.setDouble(3, item.getItemshippingCost());
            statement.setInt(4, item.getPreparationTime());
            statement.setDouble(5, item.getSellPrice());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
    }

    @Override
    public Item getItemByCode(String code) {
        Item item = ItemFactory.getItem();
        database.connect();
        try {
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ITEM_FIND_BY_CODE);
            statement.setString(1, code);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                item.setId(result.getInt("id"));
                item.setCode(result.getString("code"));
                item.setDescription(result.getString("description"));
                item.setItemshippingCost(result.getDouble("shipping_cost"));
                item.setPreparationTime(result.getInt("preparation_time"));
                item.setSellPrice(result.getDouble("sell_price"));
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return item;
    }

    @Override
    public int getItemPreparationTimeById(int id) {
        int preparationTime = 0;
        database.connect();
        try {
            PreparedStatement statement = database.connection.prepareStatement(QueryConstant.QUERY_ITEM_GET_PREPARATION_TIME_BY_ID);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                preparationTime = result.getInt("preparation_time");
            }
            result.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            database.disconnect();
        }
        return preparationTime;
    }
}