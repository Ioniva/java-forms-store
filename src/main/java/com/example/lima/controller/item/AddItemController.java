package com.example.lima.controller.item;

import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.lima.dao.ItemDao;
import com.example.lima.factory.ItemFactory;
import com.example.lima.model.Item;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class AddItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField codeInput = new TextField();
    @FXML
    private TextField descriptionInput = new TextField();
    @FXML
    private TextField sellPriceInput = new TextField();
    @FXML
    private TextField itemshippingCostInput = new TextField();
    @FXML
    private TextField preparationTimeInput = new TextField();
    @FXML
    private Button saveButton = new Button();
    @FXML
    private Button cancelButton = new Button();

    // Definir variables
    private ItemDao dao = ItemFactory.getItemDaoImpl();
    private Item item = ItemFactory.getItem();
    Alert errorAlert = new Alert(AlertType.ERROR, "Ha ocurrido un error.");
    Alert successAlert = new Alert(AlertType.INFORMATION, "El producto ha sido creado con éxito.");

    @FXML
    void initialize() {

    }

    @FXML
    private void saveItem(ActionEvent event) throws ParseException {
        
        try {
            String code = this.codeInput.getText();
            String description = this.descriptionInput.getText();
            Double sellPrice = Double.parseDouble(this.sellPriceInput.getText());
            int itemshippingCost = Integer.parseInt(this.itemshippingCostInput.getText());
            int preparationTime = Integer.parseInt(this.preparationTimeInput.getText());

            Item item = new Item(code, description, sellPrice, itemshippingCost, preparationTime);
            dao.saveItem(item);
            successAlert.showAndWait();
            System.out.println(item);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            errorAlert.showAndWait();
        }
    }

    @FXML
    private void cancelItem(ActionEvent event) throws IOException {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    
}