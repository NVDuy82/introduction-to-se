module com.example.introductiontose {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires annotations;
    requires com.microsoft.sqlserver.jdbc;
    requires com.zaxxer.hikari;

    opens com.example.introductiontose to javafx.fxml;
    exports com.example.introductiontose;
    exports com.example.introductiontose.controller;
    exports com.example.introductiontose.controller.dangkydangnhap;
    exports com.example.introductiontose.controller.hokhau;
    exports com.example.introductiontose.controller.guithongbao;
    exports com.example.introductiontose.controller.taoKhoanPhi;

    opens com.example.introductiontose.controller to javafx.fxml;
    opens com.example.introductiontose.controller.dangkydangnhap to javafx.fxml;
    opens com.example.introductiontose.controller.guithongbao to javafx.fxml;
    opens com.example.introductiontose.controller.hokhau to javafx.fxml;
    opens com.example.introductiontose.controller.taoKhoanPhi to javafx.fxml;
}