package com.example.lima.dao;

import com.example.lima.model.Item;

import javafx.collections.ObservableList;



public interface ItemDao {

    ObservableList<Item> getAllItems();

    void saveItem(Item item);

    Item getItemByCode(String code);

    int getItemPreparationTimeById(int id);

}
