module com.example.lima {
    requires javafx.controls;
    requires javafx.fxml;
    requires jakarta.persistence;
    requires jakarta.transaction;
    requires lombok;
    requires org.hibernate.orm.core;
    requires java.naming;

    exports com.example.lima;
    exports com.example.lima.controller;
    exports com.example.lima.controller.order;

    opens com.example.lima to javafx.base;
    opens com.example.lima.controller to javafx.fxml;
    opens com.example.lima.controller.order to javafx.fxml;

    exports com.example.lima.controller.item; 
    opens com.example.lima.controller.item to javafx.fxml;

    exports com.example.lima.controller.customer; 
    opens com.example.lima.controller.customer to javafx.fxml;
}
