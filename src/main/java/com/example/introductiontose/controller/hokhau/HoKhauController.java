package com.example.introductiontose.controller.hokhau;

import com.example.introductiontose.dao.DataAccessObject;
import com.example.introductiontose.dao.NhanKhauDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhau;
import com.example.introductiontose.util.AlertUtils;
import com.example.introductiontose.util.SQLUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * Controller cho giao diện quản lý hộ khẩu, chứa các chức năng như đổi chủ hộ, thêm nhân khẩu, xóa nhân khẩu,
 * tách khẩu, hiển thị danh sách hộ.
 *
 * @author Duy
 * @version 1.0
 */
public class HoKhauController implements Initializable {
    @FXML
    private Button buttonMenuDoiChuHo;
    @FXML
    private Button buttonMenuThemNhanKhau;
    @FXML
    private Button buttonMenuXoaNhanKhau;
    @FXML
    private Button buttonMenuTachKhau;
    @FXML
    private Pane paneContent;
    private HoKhau hoKhau;
    private int idHoKhau;
    private Button selectedButton;
    
    /**
     * Phương thức khởi tạo giao diện quản lý hộ khẩu, thiết lập sự kiện cho các nút chức năng.
     *
     * @param url            Đối tượng URL của giao diện FXML.
     * @param resourceBundle Đối tượng ResourceBundle chứa các tài nguyên local.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        idHoKhau = 1;
        initButton();
    }
    
    /**
     * Phương thức để thiết lập đối tượng HoKhau cho controller.
     *
     * @param hoKhau Đối tượng HoKhau cần thiết lập.
     */
    public void setHoKhau(HoKhau hoKhau) {
        this.hoKhau = hoKhau;
        this.idHoKhau = hoKhau.getIdHoKhau();
    }
    
    /**
     * Phương thức hiển thị giao diện đổi chủ hộ.
     *
     * @param event Sự kiện nhấn nút "Đổi Chủ Hộ".
     */
    @FXML
    private void showDoiChuHo(ActionEvent event) {
        DanhSachHoController controller = new DoiChuHoController();
        loadDanhSachHo(controller);
    }
    
    /**
     * Phương thức hiển thị giao diện thêm nhân khẩu.
     *
     * @param event Sự kiện nhấn nút "Thêm Nhân Khẩu".
     */
    @FXML
    private void showThemNhanKhau(ActionEvent event) {
        loadThemNhanKhau();
    }
    
    /**
     * Phương thức hiển thị giao diện xóa nhân khẩu.
     *
     * @param event Sự kiện nhấn nút "Xóa Nhân Khẩu".
     */
    @FXML
    private void showXoaNhanKhau(ActionEvent event) {
        DanhSachHoController controller = new XoaNhanKhauController();
        loadDanhSachHo(controller);
    }
    
    /**
     * Phương thức hiển thị giao diện tách khẩu.
     *
     * @param event Sự kiện nhấn nút "Tách Khẩu".
     */
    @FXML
    private void showTachKhau(ActionEvent event) {
        DanhSachHoController controller = new TachKhauController();
        loadDanhSachHo(controller);
    }
    
    /**
     * Phương thức thiết lập sự kiện cho các nút chức năng và hiệu ứng khi chọn.
     */
    private void initButton() {
        List<Button> buttonMenu = Arrays.asList(buttonMenuDoiChuHo, buttonMenuThemNhanKhau,
                buttonMenuXoaNhanKhau, buttonMenuTachKhau);
        
        for (Button button : buttonMenu) {
            button.setOnMouseClicked(event -> {
                if (button != selectedButton) {
                    if (selectedButton != null) {
                        selectedButton.getStyleClass().remove("btn-menu-on-select");
                    }
                    button.getStyleClass().add("btn-menu-on-select");
                    selectedButton = button;
                }
            });
        }
    }
    
    /**
     * Phương thức hiển thị giao diện danh sách hộ và chạy controller tương ứng.
     *
     * @param controller Controller của danh sách hộ cần chạy.
     */
    private void loadDanhSachHo(DanhSachHoController controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/hokhau/ho-khau-danh-sach-ho.fxml"));
        
        paneContent.getChildren().clear();
        fxmlLoader.setController(controller);
        
        try {
            paneContent.getChildren().add(fxmlLoader.load());
            List<NhanKhau> nhanKhauList = getNhanKhauList();
            if (nhanKhauList == null) return;
            
            controller.launch(this.hoKhau, nhanKhauList);
        } catch (IOException e) {
            e.printStackTrace();
            AlertUtils.showAlertError("Lỗi", "Xảy ra lỗi trong phần mềm.");
        }
    }
    
    /**
     * Phương thức hiển thị giao diện thêm nhân khẩu.
     */
    private void loadThemNhanKhau() {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/hokhau/ho-khau-them-nhan-khau.fxml"));
        
        try {
            paneContent.getChildren().clear();
            paneContent.getChildren().add(fxmlLoader.load());
        } catch (IOException e) {
            AlertUtils.showAlertError("Lỗi", "Xảy ra lỗi trong phần mềm.");
        }
    }
    
    /**
     * Phương thức lấy danh sách nhân khẩu của hộ từ cơ sở dữ liệu.
     *
     * @return Danh sách nhân khẩu hoặc null nếu có lỗi.
     */
    private List<NhanKhau> getNhanKhauList() {
        try {
            return SQLUtils.getNhanKhauFromHoKhau(idHoKhau);
        } catch (SQLException e) {
            // lỗi kết nối
            
            return null;
        }
    }
}
