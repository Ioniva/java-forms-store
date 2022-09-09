package com.example.lima.constant;

public class QueryConstant {

    // Item
    public static final String QUERY_ITEM_GET_ALL = "SELECT * FROM lima.item";
    public static final String QUERY_ITEM_CREATE = "INSERT INTO lima.item (code, description, shipping_cost, preparation_time, sell_price) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_ITEM_FIND_BY_CODE = "SELECT * FROM lima.item WHERE code = ?";
    public static final String QUERY_ITEM_GET_PREPARATION_TIME_BY_ID = "SELECT preparation_time FROM lima.item WHERE id = ?";

    // Customer
    public static final String QUERY_CUSTOMER_GET_ALL = "SELECT * FROM lima.customer";
    public static final String QUERY_CUSTOMER_CREATE = "INSERT INTO lima.customer (name, nif, address, email, customer_type) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_CUSTOMER_GET_ALL_BY_TYPE = "SELECT * FROM lima.customer WHERE customer_type = ?";
    public static final String QUERY_CUSTOMER_GET_BY_NIF = "SELECT * FROM lima.customer WHERE nif = ?";

    // Order
    public static final String QUERY_ORDER_CREATE = "INSERT INTO lima.order (item_id, customer_id, order_date, ready_to_ship, units) VALUES (?, ?, ?, ?, ?)";
    public static final String QUERY_ORDER_DELETE = "DELETE FROM lima.order WHERE id = ?";
    public static final String QUERY_ORDER_BY_ID = "SELECT * FROM lima.order WHERE id = ?";
    public static final String QUERY_ORDER_IS_SEND_FILTERED = "SELECT * FROM lima.order WHERE customer_id = ? AND ready_to_ship = ?";
    public static final String QUERY_ORDER_IS_SEND = "SELECT * FROM lima.order WHERE ready_to_ship = ?";
}
