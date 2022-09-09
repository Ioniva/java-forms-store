package com.example.lima.controller.customer;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;

import com.example.lima.dao.CustomerDao;
import com.example.lima.factory.CustomerFactory;
import com.example.lima.model.Premium;
import com.example.lima.model.Standard;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddCustomerController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private TextField emailInput = new TextField();
    @FXML
    private TextField nifInput = new TextField();
    @FXML
    private TextField addressInput = new TextField();
    @FXML
    private TextField nameInput = new TextField();
    @FXML
    private TextField customerTypeInput = new TextField();

    @FXML
    private Button saveButton = new Button();
    @FXML
    private Button cancelButton = new Button();

    @FXML
    void initialize() {
    }

    private CustomerDao dao = CustomerFactory.getCustomerDaoImpl();

    Alert errorAlert = new Alert(AlertType.ERROR, "Ha ocurrido un error.");
    Alert successAlert = new Alert(AlertType.INFORMATION, "El cliente ha sido creado con éxito.");

    @FXML
    private void saveCustomer(ActionEvent event) {
        try {
            String email = emailInput.getText();
            String nif = nifInput.getText();
            String address = addressInput.getText();
            String name = nameInput.getText();
            String customerType = customerTypeInput.getText();

            if (customerType.contains("Estandar")) {
                Standard customer = new Standard(email, nif, address, name, customerType);
                dao.saveCustomer(customer);
            }
            if (customerType.contains("Premium")) {
                Premium customer = new Premium(email, nif, address, name, customerType);
                dao.saveCustomer(customer);
            }

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
    private void cancelCustomer(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }
}
