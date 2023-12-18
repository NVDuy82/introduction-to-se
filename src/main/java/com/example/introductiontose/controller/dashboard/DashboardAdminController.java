package com.example.introductiontose.controller.dashboard;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.image.Image;
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

    private Pane thongKeNKPane, thongKeTPPane, danhSachNKPane, danhSachTPPane, trangChuPane, caiDatPane, thongTinPane;

    @FXML
    private HBox trangChu, caiDat, thongTin;

    @FXML
    private VBox thongTinNguoiDung;

    @FXML
    private Button chiTiet, nutThongBao, thoat, thuNho;

    @FXML
    private ImageView anhDaiDien;

    @FXML
    private TreeView<HBox> QLNhanKhau;

    @FXML
    private TreeView<HBox> QLThuPhi;
    private Popup popup;

    // Biến để theo dõi trạng thái mở rộng
    private boolean isExpandedNK = false;
    private boolean isExpandedTP = false;


    private void createPopup() {
        popup = new Popup();
        Label label = new Label("Thông tin chi tiết người dùng");
        // Cấu hình thêm cho label nếu cần
        popup.getContent().add(label);
    }

    @FXML
    private void onTrangChuClicked(MouseEvent event) {
        if (trangChuPane == null) {
            trangChuPane = loadNewFXML("trangChu.fxml");
        }
        if (trangChuPane != null) {
            Dashboard.setCenter(trangChuPane);
        }
    }
    @FXML
    private void onQLNhanKhauClicked(MouseEvent event) {
        isExpandedNK = !isExpandedNK; // Đảo trạng thái
        toggleTreeItems(QLNhanKhau.getRoot(), isExpandedNK);
    }

    @FXML
    private void onCaiDatClicked(MouseEvent event) {
        if (caiDatPane == null) {
            caiDatPane = loadNewFXML("caiDat.fxml");
        }
        if (caiDatPane != null) {
            Dashboard.setCenter(caiDatPane);
        }
    }

    @FXML
    private void onQLThuPhiClicked(MouseEvent event) {
        isExpandedTP = !isExpandedTP; // Đảo trạng thái
        toggleTreeItems(QLThuPhi.getRoot(), isExpandedTP);
    }

    @FXML
    private void onThongTinClicked(MouseEvent event) {
        if (thongTinPane == null) {
            thongTinPane = loadNewFXML("thongTin.fxml");
        }
        if (thongTinPane != null) {
            Dashboard.setCenter(thongTinPane);
        }
    }

    @Override
    public void updateCenterContent(String fxmlPath) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
        try {
            Pane newPane = loader.load();
            Dashboard.setCenter(newPane);
        } catch (IOException e) {
            e.printStackTrace();
            // Xử lý lỗi tại đây
        }
    }


    // Di chuyển HBox sang phải 15px khi di chuột vào
    @FXML
    private void onMouseEnteredHBox(MouseEvent event) {
        HBox source = (HBox) event.getSource();
        source.setTranslateX(15);
    }

    // Quay lại vị trí ban đầu khi di chuột ra
    @FXML
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

    private void toggleTreeItems(TreeItem<?> item, boolean expand) {
        if (item != null && !item.isLeaf()) {
            item.setExpanded(expand);
            for (TreeItem<?> child : item.getChildren()) {
                toggleTreeItems(child, expand);
            }
        }
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
        // Đăng ký sự kiện cho các HBox
        trangChu.setOnMouseEntered(this::onMouseEnteredHBox);
        trangChu.setOnMouseExited(this::onMouseExitedHBox);
        QLNhanKhau.setOnMouseEntered(this::onMouseEnteredHBox);
        QLNhanKhau.setOnMouseExited(this::onMouseExitedHBox);
        QLThuPhi.setOnMouseEntered(this::onMouseEnteredHBox);
        QLThuPhi.setOnMouseExited(this::onMouseExitedHBox);
        caiDat.setOnMouseEntered(this::onMouseEnteredHBox);
        caiDat.setOnMouseExited(this::onMouseExitedHBox);
        thongTin.setOnMouseEntered(this::onMouseEnteredHBox);
        thongTin.setOnMouseExited(this::onMouseExitedHBox);

        // Đăng ký sự kiện cho VBox
        thongTinNguoiDung.setOnMouseEntered(this::onMouseEnteredVBox);
        thongTinNguoiDung.setOnMouseExited(this::onMouseExitedVBox);

        // Đăng ký sự kiện cho nút
        chiTiet.setOnAction(e -> onButtonClicked());
        nutThongBao.setOnAction(e -> onButtonClicked());
        thoat.setOnAction(e -> onExitClicked());
        thuNho.setOnAction((e -> onMinimizeClicked()));

        // Tải pane
        trangChu.setOnMouseClicked(this::onTrangChuClicked);
        QLNhanKhau.setOnMouseClicked(this::onQLNhanKhauClicked);
        QLThuPhi.setOnMouseClicked(this::onQLThuPhiClicked);
        caiDat.setOnMouseClicked(this::onCaiDatClicked);
        thongTin.setOnMouseClicked(this::onThongTinClicked);
        // Tạo popup
        createPopup();

        // Khởi tạo gốc của cây
        TreeItem<HBox> rootItemNK = createTreeItem("QL Nhân khẩu", "path/to/root/icon.png");

        // Thêm các TreeItem con
        rootItemNK.getChildren().add(createTreeItem("Thống kê", "path/to/statistics/icon.png"));
        rootItemNK.getChildren().add(createTreeItem("Danh sách", "path/to/list/icon.png"));
        rootItemNK.getChildren().add(createTreeItem("Duyệt yêu cầu", "path/to/request/icon.png"));

        // Cài đặt gốc và mở rộng nó
        QLNhanKhau.setRoot(rootItemNK);
        QLNhanKhau.setShowRoot(true);
        rootItemNK.setExpanded(false);

        // Sử dụng CellFactory để tùy chỉnh hiển thị của TreeItem
        setupCellFactory(QLNhanKhau);

        // Khởi tạo gốc của cây
        TreeItem<HBox> rootItemTP = createTreeItem("QL Thu phí", "path/to/root/icon.png");

        // Thêm các TreeItem con
        rootItemTP.getChildren().add(createTreeItem("Thống kê", "path/to/statistics/icon.png"));
        rootItemTP.getChildren().add(createTreeItem("Danh sách", "path/to/list/icon.png"));
        rootItemTP.getChildren().add(createTreeItem("Duyệt yêu cầu", "path/to/request/icon.png"));

        // Cài đặt gốc và mở rộng nó
        QLThuPhi.setRoot(rootItemTP);
        QLThuPhi.setShowRoot(true);
        rootItemTP.setExpanded(false);

        // Sử dụng CellFactory để tùy chỉnh hiển thị của TreeItem
        setupCellFactory(QLThuPhi);
    }

    private void setupCellFactory(TreeView<HBox> treeView) {
        treeView.setCellFactory(tv -> new TreeCell<HBox>() {
            @Override
            protected void updateItem(HBox item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setGraphic(item);
                }
            }
        });
    }

    // Phương thức tạo TreeItem với HBox chứa ImageView và Label
    private TreeItem<HBox> createTreeItem(String text, String imagePath) {
        ImageView imageView = new ImageView(new Image(imagePath));
        imageView.setFitHeight(24); // Đặt kích thước cho hình ảnh
        imageView.setFitWidth(24);

        Label label = new Label(text);
        HBox hbox = new HBox(20, imageView, label); // 20 là khoảng cách giữa ImageView và Label

        return new TreeItem<>(hbox);
    }
}
