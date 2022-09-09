package com.example.lima.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HelloController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label welcomeText;

    @FXML
    private Button btnOrderView;
    
    @FXML
    private Button btnItemView;

    @FXML
    private Button btnCustomerView;

    @FXML
    void click(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/view/order/ShowOrder.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    void customerClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/view/customer/ShowCustomer.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void itemClick(ActionEvent event) throws Exception {
        root = FXMLLoader.load(getClass().getResource("/view/item/ShowItem.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onHelloButtonClick(ActionEvent event) {}
    
    @FXML
    void initialize() {
        assert welcomeText != null : "fx:id=\"welcomeText\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnOrderView != null : "fx:id=\"btnOrderView\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnCustomerView != null : "fx:id=\"btnCustomerView\" was not injected: check your FXML file 'hello-view.fxml'.";
        assert btnItemView != null : "fx:id=\"btnOrderView\" was not injected: check your FXML file 'hello-view.fxml'.";
    }
}
