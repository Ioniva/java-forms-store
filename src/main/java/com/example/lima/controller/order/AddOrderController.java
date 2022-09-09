package com.example.lima.controller.order;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.lima.dao.OrderDao;
import com.example.lima.factory.OrderFactory;
import com.example.lima.model.Order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddOrderController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField nifInput = new TextField();
    @FXML
    private TextField qtyInput = new TextField();
    @FXML
    private DatePicker dateInput = new DatePicker();
    @FXML
    private TextField itemInput = new TextField();
    @FXML
    private Button saveButton = new Button();
    @FXML
    private Button cancelButton = new Button();

    // Definir variables
    private OrderDao dao = OrderFactory.getOrderDao();
    Alert errorAlert = new Alert(AlertType.ERROR, "Ha ocurrido un error.");
    Alert successAlert = new Alert(AlertType.INFORMATION, "El pedido ha sido creado con éxito.");

    @FXML
    void initialize() {
    }

    @FXML
    private void saveOrder(ActionEvent event) {
        try {
            int clientCode = Integer.parseInt(this.nifInput.getText());
            int itemCode = Integer.parseInt(this.itemInput.getText());
            int amount = Integer.parseInt(this.qtyInput.getText());
            Date orderDate = new SimpleDateFormat("dd-MM-yyyy").parse(this.dateInput.getValue().toString());

            // TODO: Estaria pendiente comprobar si existe o no el cliente
            // TODO: Recoger el id del cliente
            // TODO: Recoger el id del producto

            Order order = new Order(amount, orderDate, clientCode, itemCode, false);
            dao.saveOrder(order);

            if (successAlert.showAndWait().get() == ButtonType.OK) {
                Stage stage = (Stage) cancelButton.getScene().getWindow();
                stage.close();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    private void cancelOrder(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
