package com.example.lima.controller.order;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import com.example.lima.dao.OrderDao;
import com.example.lima.factory.OrderFactory;
import com.example.lima.model.Order;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class DeleteOrderController {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField idInput = new TextField();
    @FXML
    private Button deleteButton = new Button();
    @FXML
    private Button cancelButton = new Button();

    // Definir variables
    private OrderDao dao = OrderFactory.getOrderDao();
    Alert errorAlert = new Alert(AlertType.ERROR, "Ha ocurrido un error al intentar borrar el pedido.");
    Alert successAlert = new Alert(AlertType.INFORMATION, "El pedido ha sido borrado con éxito.");

    @FXML
    void initialize() {
    }

    @FXML
    private void deleteOrder(ActionEvent event) throws IOException {
        int id = Integer.valueOf(idInput.getText());

        if (contains(id)) {
            Order order = dao.getOrderById(id);
            dao.deleteOrder(order);
        } else {
            errorAlert.setTitle("Error");
            errorAlert.setContentText("El pedido no existe.");
            errorAlert.show();
            return;
        }

        if (successAlert.showAndWait().get() == ButtonType.OK) {
            Stage stage = (Stage) cancelButton.getScene().getWindow();
            stage.close();
        }
    }

    @FXML
    private void cancelOrder(ActionEvent event) {
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    private boolean contains(int id) {
        for (Order o : dao.getAllOrders()) {
            if (o.getId() == id) {
                return true;
            }
        }
        return false;
    }
}
