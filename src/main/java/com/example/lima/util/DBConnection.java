package com.example.lima.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {
    private static final String DB_USERNAME="db.username";
    private static final String DB_PASSWORD="db.password";
    private static final String DB_URL="db.url";

    public Connection connection = null;
    private static Properties properties = null;
    private static final DBConnection connectionInstance = new DBConnection();

    public static DBConnection getInstance() {
        return connectionInstance;
    }

    public void connect(){
        try {
            properties = new Properties();
            properties.load(new FileInputStream(".//src/main/resources/database.properties"));
            connection = DriverManager.getConnection(properties.getProperty(DB_URL), properties.getProperty(DB_USERNAME), properties.getProperty(DB_PASSWORD));
        } catch (SQLException | IOException e){
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            if(connection != null && (!connection.isClosed())) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}