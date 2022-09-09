package com.example.lima.controller.item;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.lima.dao.ItemDao;
import com.example.lima.factory.ItemFactory;
import com.example.lima.model.Item;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ShowItemController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem btnAddMenuItem;

    @FXML
    private MenuItem btnShowMenuItem;

    @FXML
    private Menu menuItem;

    @FXML
    private MenuItem addMenuItem;

    @FXML
    private MenuItem showMenuItem;

    @FXML
    private Button refreshButton = new Button();

    @FXML
    private Button backButton = new Button();

    @FXML
    private TableView<Item> itemTable;
    @FXML
    private TableColumn<Item, Integer> colId;
    @FXML
    private TableColumn<Item, String> colCode;
    @FXML
    private TableColumn<Item, String> colDescription;
    @FXML
    private TableColumn<Item, Double> colSellPrice;
    @FXML
    private TableColumn<Item, Double> colItemshippingCost;
    @FXML
    private TableColumn<Item, Integer> colPreparationTime;

    // Definir variables
    private ItemDao item = ItemFactory.getItemDaoImpl();

    public void clickAddMenu(ActionEvent event) {
        try {
            // Carga la vista
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/item/AddItem.fxml"));

            // Cargo el padre
            Parent root = loader.load();

            // Creo la scene
            Scene scene = new Scene(root);

            // Creo la stage
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setScene(scene);
            stage.setTitle("Añadir Producto");
            stage.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void clickShowMenu(ActionEvent event) {

    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    private void initialize() {
        this.colId.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getId()));
        this.colCode.setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getCode()));
        this.colDescription
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getDescription()));
        this.colSellPrice
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getSellPrice()));
        this.colItemshippingCost.setCellValueFactory(
                cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getItemshippingCost()));
        this.colPreparationTime
                .setCellValueFactory(cellData -> new ReadOnlyObjectWrapper<>(cellData.getValue().getPreparationTime()));

        this.loadItems();

    }

    private void loadItems() {
        ObservableList<Item> itemList = item.getAllItems();
        this.itemTable.setItems(itemList);

    }

    @FXML
    private void refreshTable(ActionEvent event) throws IOException {
        ObservableList<Item> itemList = item.getAllItems();
        this.itemTable.setItems(itemList);
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
            stage2.setTitle("Productos");
            stage2.showAndWait();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
