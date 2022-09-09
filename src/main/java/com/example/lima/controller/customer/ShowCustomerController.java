package com.example.lima.controller.customer;

import java.net.URL;
import java.util.ResourceBundle;

import com.example.lima.dao.CustomerDao;
import com.example.lima.factory.CustomerFactory;
import com.example.lima.model.Customer;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowCustomerController {
    @FXML private ResourceBundle resources;
    @FXML private URL location;

    @FXML private Menu menuCustomer;
    @FXML private MenuItem btnAddMenuCustomer;
    @FXML private MenuItem btnShowMenuCustomer;
    @FXML private MenuItem addMenuCustomer;
    @FXML private MenuItem showMenuCustomer;

    @FXML private RadioButton standardRadio = new RadioButton();
    @FXML private RadioButton premiumRadio = new RadioButton();

    @FXML private TableView<Customer> customerTable;
    @FXML private TableColumn<Customer, Integer> colId;
    @FXML private TableColumn<Customer, String> colEmail;
    @FXML private TableColumn<Customer, String> colNif;
    @FXML private TableColumn<Customer, String> colAddress;
    @FXML private TableColumn<Customer, String> colName;
    @FXML private TableColumn<Customer, String> colCustomerType;

    @FXML private Button btnRefreshTable;
    @FXML private Button backButton;

    private CustomerDao customer = CustomerFactory.getCustomerDaoImpl();

    @FXML
    void clickAddMenuCustomer(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/customer/AddCustomer.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir Cliente");
            stage.showAndWait();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    void clickShowMenuCustomer(ActionEvent event) {}

    @FXML // This method is called by the FXMLLoader when initialization is complete
    private void initialize() {
        this.colId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        this.colEmail.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getEmail()));
        this.colNif.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getNif()));
        this.colAddress.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getAddress()));
        this.colName.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getName()));
        this.colCustomerType.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCustomerType()));
        
        this.loadCustomers();
    }

    @FXML
    void refreshTable(ActionEvent event) {
        this.loadCustomers();
    }

    @FXML
    void getAllCustomersByType(ActionEvent event) {
        this.loadCustomers();
    }

    @FXML
    private void backToMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/hello-view.fxml"));
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);

            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setScene(scene);
            stage2.setTitle("Hello!");
            stage2.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void loadCustomers() {
        if (this.standardRadio.isSelected()) {
            ObservableList<Customer> customerList = customer.getAllCustomersByType("Estandar");
            this.customerTable.setItems(customerList);
        }
        if (this.premiumRadio.isSelected()) {
            ObservableList<Customer> customerList = customer.getAllCustomersByType("Premium");
            this.customerTable.setItems(customerList);
        }
    }
}
    

