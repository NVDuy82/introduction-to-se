package com.example.introductiontose.controller.dashboard;

import com.example.introductiontose.view.icon.IconUtils;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class DashboardAdminController implements Initializable, CenterContent {
    @FXML
    private BorderPane Dashboard;
    //Các Pane hoặc FXML loader cho từng chức năng

    private Pane trangChuPane, caiDatPane, thongTinPane;
    private Pane thongKeNKPane, danhSachNKPane, yeuCauNKPane;
    private Pane thongKeTPPane, danhSachTPPane, yeuCauTPPane, taoKhoanPhiPane;

    @FXML
    private Button thoat;
    @FXML
    private Button thuNho;
    @FXML
    private ImageView anhDaiDien;
    @FXML
    private VBox thongTinNguoiDung;
    @FXML
    private Button chiTiet;
    @FXML
    private Button nutThongBao;

    @FXML
    private Button TrangChu;
    @FXML
    private TitledPane QuanLyNhanKhau;
    @FXML
    private Button thongKeNK, danhSachNK, yeuCauNK;
    @FXML
    private Button thongKeTP, danhSachTP, yeuCauTP, taoKhoanPhi;
    @FXML
    private TitledPane QuanLyThuPhi;
    @FXML
    private Button CaiDat;

    @FXML
    private HBox thongTin;

    private Popup popup;

    // Event handlers
    @FXML
    void onTrangChuClicked() {
        // Xử lý sự kiện khi "Trang chủ" được nhấn
        if (trangChuPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/TrangChu.fxml"));
                trangChuPane = loader.load();
                System.out.println("load trang chu thanh cong");
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(trangChuPane);
        }
        else updateCenterContent(trangChuPane);
    }

    @FXML
    void onThongKeNKClicked() {
        // Xử lý sự kiện khi "Thống kê" trong "Quản lý nhân khẩu" được nhấn
        if (thongKeNKPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/ThongKeNhanKhau.fxml"));
                thongKeNKPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(thongKeNKPane);
        }
        else updateCenterContent(thongKeNKPane);
    }

    @FXML
    void onDanhSachNKClicked() {
        // Xử lý sự kiện khi "Danh sách" trong "Quản lý nhân khẩu" được nhấn
        if (danhSachNKPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/hokhau/DanhSachNhanKhau.fxml"));
                danhSachNKPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(danhSachNKPane);
        }
        else updateCenterContent(danhSachNKPane);
    }

    @FXML
    void onYeuCauNKClicked() {
        // Xử lý sự kiện khi "Duyệt yêu cầu" trong "Quản lý nhân khẩu" được nhấn
        if (yeuCauNKPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/YeuCauNhanKhau.fxml"));
                yeuCauNKPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(yeuCauNKPane);
        }
        else updateCenterContent(yeuCauNKPane);
    }

    @FXML
    void onThongKeTPClicked() {
        // Xử lý sự kiện khi "Thống kê" trong "Quản lý thu phí" được nhấn
        if (thongKeTPPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/ThongKeThuPhi.fxml"));
                thongKeTPPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(thongKeTPPane);
        }
        else updateCenterContent(thongKeTPPane);
    }

    @FXML
    void onDanhSachTPClicked() {
        // Xử lý sự kiện khi "Danh sách" trong "Quản lý thu phí" được nhấn
        if (danhSachTPPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/DanhSachKhoanPhi.fxml"));
                danhSachTPPane = loader.load();
            }
            catch (Exception e) {
                e.printStackTrace();
            }
            updateCenterContent(danhSachTPPane);
        }
        else updateCenterContent(danhSachTPPane);

        System.out.println(danhSachTPPane);
    }

    @FXML
    void onYeuCauTPClicked() {
        // Xử lý sự kiện khi "Duyệt yêu cầu" trong "Quản lý thu phí" được nhấn
        if (yeuCauTPPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/TrangChu.fxml"));
                yeuCauTPPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(yeuCauTPPane);
        }
        else updateCenterContent(yeuCauTPPane);

    }

    @FXML
    void onTaoKhoanPhiClicked() {
        // Xử lý sự kiện khi "Tạo khoản phí" trong "Quản lý thu phí" được nhấn
        if (taoKhoanPhiPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/TrangChu.fxml"));
                taoKhoanPhiPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(taoKhoanPhiPane);
        }
        else updateCenterContent(taoKhoanPhiPane);
    }

    @FXML
    void onCaiDatClicked() {
        // Xử lý sự kiện khi "Cài đặt" được nhấn
        if (caiDatPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/TrangChu.fxml"));
                caiDatPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(caiDatPane);
        }
        else updateCenterContent(caiDatPane);
    }

    @FXML
    void onThongTinClicked() {
        // Xử lý sự kiện khi "Thông tin" được nhấn
        if (thongTinPane == null) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/TrangChu.fxml"));
                thongTinPane = loader.load();
            }
            catch (Exception e) {
                //
            }
            updateCenterContent(thongTinPane);
        }
        else updateCenterContent(thongTinPane);
    }

    private void createPopup() {
        popup = new Popup();
        Label label = new Label("Thông tin chi tiết người dùng");
        // Cấu hình thêm cho label nếu cần
        popup.getContent().add(label);
    }

    @Override
    public void updateCenterContent(Pane pane) {
        Dashboard.setCenter(pane);
    }


    // Di chuyển HBox sang phải 15px khi di chuột vào

    private void onMouseEnteredHBox(MouseEvent event) {
        HBox source = (HBox) event.getSource();
        source.setTranslateX(15);
    }

    // Quay lại vị trí ban đầu khi di chuột ra

    private void onMouseExitedHBox(MouseEvent event) {
        HBox source = (HBox) event.getSource();
        source.setTranslateX(0);
    }

    // Hiển thị popup thông tin người dùng
    @FXML
    private void onMouseEnteredVBox(MouseEvent event) {
        // Tính toán vị trí của popup
        Node source = (Node) event.getSource();
        Window theStage = source.getScene().getWindow();
        popup.show(theStage, theStage.getX() + source.localToScene(0, 0).getX() + source.getScene().getX(),
                theStage.getY() + source.localToScene(0, 0).getY() + source.getScene().getY() + source.getBoundsInParent().getHeight());

    }
    // Ẩn popup khi di chuột ra
    @FXML
    private void onMouseExitedVBox(MouseEvent event) {
        popup.hide();
    }
    // Hiển thị danh sách thông báo
    @FXML
    private void onButtonClicked() {
        // Logic để hiển thị danh sách thông báo
    }

    @FXML
    private void onExitClicked() {
        Platform.exit();
    }

    @FXML
    private void onMinimizeClicked() {
        Stage stage = (Stage) thuNho.getScene().getWindow(); // 'thuNho' là fx:id của nút thu nhỏ
        // Thu nhỏ cửa sổ
        stage.setIconified(true);
    }
    private Pane loadNewFXML(String fxmlFileName) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFileName));
        try {
            return loader.load();
        } catch (IOException e) {
            // Xử lý nếu có lỗi khi tải FXML
            e.printStackTrace();
            return null;
        }
    }

    @FXML
    public void initialize(URL location, ResourceBundle resources) {


        // Đăng ký sự kiện cho VBox
        thongTinNguoiDung.setOnMouseEntered(this::onMouseEnteredVBox);
        thongTinNguoiDung.setOnMouseExited(this::onMouseExitedVBox);

        // Đăng ký sự kiện cho nút
        chiTiet.setOnAction(e -> onButtonClicked());
        nutThongBao.setOnAction(e -> onButtonClicked());
        thoat.setOnAction(e -> onExitClicked());
        thuNho.setOnAction((e -> onMinimizeClicked()));

        // Tải pane
        // Tạo popup
        createPopup();

        onTrangChuClicked();
    }
}