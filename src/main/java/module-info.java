module com.example.introductiontose {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires annotations;
    requires com.microsoft.sqlserver.jdbc;
    requires mysql.connector.java;
    requires com.zaxxer.hikari;
    
    exports com.example.introductiontose;
    opens com.example.introductiontose to javafx.fxml;
    exports com.example.introductiontose.controller;
    opens com.example.introductiontose.controller to javafx.fxml;
    exports com.example.introductiontose.controller.hokhau;
    opens com.example.introductiontose.controller.hokhau to javafx.fxml;
    exports com.example.introductiontose.view.icon;
    opens com.example.introductiontose.view.icon to javafx.fxml;
    exports com.example.introductiontose.model;
    opens com.example.introductiontose.model to javafx.fxml;
    exports com.example.introductiontose.controller.taikhoan;
    opens com.example.introductiontose.controller.taikhoan to javafx.fxml;
}