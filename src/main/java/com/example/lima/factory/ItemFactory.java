package com.example.lima.factory;

import com.example.lima.dao.impl.ItemDaoImpl;
import com.example.lima.model.Item;


public class ItemFactory {

    public static Item getItem() { return new Item();}

    public static ItemDaoImpl getItemDaoImpl(){
        return new ItemDaoImpl();
    } 

}