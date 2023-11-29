module com.example.introductiontose {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires annotations;
    requires com.microsoft.sqlserver.jdbc;
    
    opens com.example.introductiontose to javafx.fxml;
    exports com.example.introductiontose;
    exports com.example.introductiontose.controller;
    opens com.example.introductiontose.controller to javafx.fxml;
    exports com.example.introductiontose.controller.hokhau;
    opens com.example.introductiontose.controller.hokhau to javafx.fxml;
    exports com.example.introductiontose.view.icon;
    opens com.example.introductiontose.view.icon to javafx.fxml;
}