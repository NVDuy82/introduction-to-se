package com.example.introductiontose.controller.admin;

import com.example.introductiontose.dao.HoKhauDAO;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.dao.ThayDoiHoKhauDAO;
import com.example.introductiontose.dao.ThayDoiNhanKhauDao;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.model.ThayDoiHoKhau;
import com.example.introductiontose.model.ThayDoiNhanKhau;
import com.example.introductiontose.model.key.HoKhauKey;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class YeuCauNhanKhauController {
    @FXML
    private VBox VBoxList;
    @FXML
    private Text hienThiChiTiet;


}
