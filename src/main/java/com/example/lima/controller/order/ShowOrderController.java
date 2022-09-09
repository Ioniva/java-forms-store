package com.example.lima.controller.order;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.example.lima.dao.OrderDao;
import com.example.lima.factory.OrderFactory;
import com.example.lima.model.Order;

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

public class ShowOrderController {
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;

    @FXML
    private Menu menuOrder;
    @FXML
    private MenuItem btnAddMenuOrder;
    @FXML
    private MenuItem btnDeleteMenuOrder;
    @FXML
    private MenuItem btnShowMenuOrder;

    @FXML
    private Button backButton = new Button();

    @FXML
    private RadioButton isSendRadio = new RadioButton();
    @FXML
    private RadioButton toSentRadio = new RadioButton();
    @FXML
    private TableView<Order> orderTable;
    @FXML
    private TableColumn<Order, Integer> colId;
    @FXML
    private TableColumn<Order, Integer> colUnit;
    @FXML
    private TableColumn<Order, Date> colOrderDate;
    @FXML
    private TableColumn<Order, Integer> colCustomerId;
    @FXML
    private TableColumn<Order, Integer> colItemId;
    @FXML
    private TableColumn<Order, Boolean> colReadyToShip;

    @FXML
    private Button btnRefreshTable;

    // Definir variables
    private OrderDao order = OrderFactory.getOrderDao();

    /**
     * Opciones del menu
     *
     * @param event
     */
    public void clickAddMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/order/AddOrder.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir pedido");
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickDeleteMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/order/DeleteOrder.fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);

            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Borrar pedido");
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickShowMenu(ActionEvent event) {
    }

    /**
     *
     */
    @FXML // This method is called by the FXMLLoader when initialization is complete
    private void initialize() {
        this.colId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        this.colUnit.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getUnits()));
        this.colOrderDate
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getOrderDate()));
        this.colCustomerId
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCustomerId()));
        this.colItemId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getItemId()));
        this.colReadyToShip
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().isReadyToShip()));

        this.loadOrders();
    }

    @FXML
    void refreshTable(ActionEvent event) {
        this.loadOrders();
    }

    @FXML
    void filterOrdersIsSent(ActionEvent event) {
        this.loadOrders();
    }

    @FXML
    void filterOrdersToSend(ActionEvent event) {
        this.loadOrders();
    }

    private void loadOrders() {
        if (this.isSendRadio.isSelected()) {
            ObservableList<Order> orderList = order.orderIsSend(true);
            this.orderTable.setItems(orderList);
        }
        if (this.toSentRadio.isSelected()) {
            ObservableList<Order> orderList = order.orderIsSend(false);
            this.orderTable.setItems(orderList);
        }
    }

    @FXML
    private void backToMenu(ActionEvent event) throws IOException {
        try {
            // Carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/hello-view.fxml"));

            // Cargo el padre
            Parent root = loader.load();
            Stage stage = (Stage) backButton.getScene().getWindow();
            stage.close();
            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage

            Stage stage2 = new Stage();
            stage2.initModality(Modality.APPLICATION_MODAL);
            stage2.setScene(scene);
            stage2.setTitle("Pedidos!");
            stage2.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
