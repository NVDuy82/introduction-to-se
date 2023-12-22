package com.example.introductiontose.controller.danhsachkhoanphi;

import com.example.introductiontose.dao.DongPhiDAO;
import com.example.introductiontose.dao.KhoanPhiDAO;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.DongPhi;
import com.example.introductiontose.model.KhoanPhi;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class DanhSachKhoanPhiAdminController implements Initializable {
    public static List<HBox> danhsachHBox = new ArrayList<>();
    public static List<HBox> danhsachHoxdongphi = new ArrayList<>();
    Connection connection = SqlConnection.connect();
    @FXML
    private VBox VBoxList;
    @FXML
    private VBox VBoxdanhsachnoptien;
    @FXML
    private HBox hBoxTimKiem;
    @FXML
    private HBox hBoxtiemkiemnoptien;
    @FXML
    private Text hienThiChiTiet;
    @FXML
    private TextField noidungtim;
    @FXML
    private TextField noidungtimnoptien;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        KhoanPhiDAO khoanPhiDAO = new KhoanPhiDAO(connection);
        List<KhoanPhi> danhsachKhoanPhi = new ArrayList<>();
        DongPhiDAO dongPhiDAO = new DongPhiDAO(connection);
        List<DongPhi> danhsachDongPhi = new ArrayList<>();
        try {
            danhsachKhoanPhi = khoanPhiDAO.getAll();
            danhsachDongPhi = dongPhiDAO.getAll();
        } catch (SQLException e) {
            throw new RuntimeException();
        }
        for (KhoanPhi khoanPhi : danhsachKhoanPhi) {
            List<String> thongtinKhoanPhi = LayThongTinKhoanPhi(khoanPhi);
            String idHBox = thongtinKhoanPhi.get(0);
            String idPhi = String.valueOf(thongtinKhoanPhi.get(1));
            String mucPhi = String.valueOf(thongtinKhoanPhi.get(2));
            String tieudePhi = thongtinKhoanPhi.get(3);
            String kieuPhi = thongtinKhoanPhi.get(4);
            String noiDung = thongtinKhoanPhi.get(5);


            HBox hBox = initHBox(idHBox, idPhi, mucPhi, tieudePhi, kieuPhi, noiDung);
            Insets hboxMargin = new Insets(10, 10, 0, 10);
            VBoxList.getChildren().add(hBox);
            VBox.setMargin(hBox, hboxMargin);
            danhsachHBox.add(hBox);
        }

        for (DongPhi dongPhi : danhsachDongPhi) {
            List<String> thongtinDongPhi = LayThongTinDongPhi(dongPhi);
            String idHBoxDongPhi = thongtinDongPhi.get(0);
            String idPhiDongPhi = String.valueOf(thongtinDongPhi.get(1));
            String idHoKhau = String.valueOf(thongtinDongPhi.get(2));
            String soTien = String.valueOf(thongtinDongPhi.get(3));
            String ngaydong = thongtinDongPhi.get(4);
            HBox hboxDongPhi = initHBox1(idHBoxDongPhi, idPhiDongPhi, idHoKhau, soTien, ngaydong);
            Insets hboxMargin = new Insets(10, 10, 0, 10);
            VBoxdanhsachnoptien.getChildren().add(hboxDongPhi);
            VBox.setMargin(hboxDongPhi, hboxMargin);
            danhsachHoxdongphi.add(hboxDongPhi);
        }

    }

    private HBox initHBox1(String idHBoxDongPhi, String idPhiDongPhi, String idHoKhau, String soTien, String ngaydong) {
        HBox hboxDongPhi = new HBox();
        hboxDongPhi.setAlignment(Pos.CENTER_LEFT);
        hboxDongPhi.setPrefHeight(80.0);
        hboxDongPhi.setPrefWidth(355.5);
        hboxDongPhi.setStyle("-fx-background-color: #ccc; -fx-background-radius: 10;");
        Insets hboxPadding = new Insets(18);
        hboxDongPhi.setPadding(hboxPadding);
        VBox vboxDongPhi = initVBox1(idPhiDongPhi, idHoKhau, soTien, ngaydong);
        hboxDongPhi.getChildren().addAll(vboxDongPhi);

        hboxDongPhi.setId(idHBoxDongPhi);
        return hboxDongPhi;

    }


    public VBox initVBox1(String idPhiBangDongPhi, String idHoKhau, String soTien, String ngaydong) {
        VBox vboxDongPhi = new VBox();
        vboxDongPhi.setPrefHeight(74.5);
        vboxDongPhi.setPrefWidth(225.0);
        vboxDongPhi.setSpacing(8);

        Label idPhiLabel = new Label(idPhiBangDongPhi);
        Label idHoKhauLabel = new Label(idHoKhau);
        Label soTienLabel = new Label(soTien);
        Label ngaydongLabel = new Label(ngaydong);

        vboxDongPhi.getChildren().addAll(idPhiLabel, idHoKhauLabel, soTienLabel, ngaydongLabel);
        vboxDongPhi.setAlignment(Pos.CENTER_LEFT);

        return vboxDongPhi;

    }


    public VBox initVBox(String kieuPhi, String mucPhi, String tieudePhi) {
        VBox vbox = new VBox();
        vbox.setPrefHeight(74.5);
        vbox.setPrefWidth(225.0);
        vbox.setSpacing(8);

        Label kieuPhiLabel = new Label(kieuPhi);
        Label mucPhiLabel = new Label(String.valueOf(mucPhi));
        Label tieuDeLabel = new Label(tieudePhi);

        vbox.getChildren().addAll(kieuPhiLabel, mucPhiLabel, tieuDeLabel);
        vbox.setAlignment(Pos.CENTER_LEFT);

        return vbox;

    }

    private HBox initHBox(String idHBox, String idPhi, String mucPhi, String tieudePhi, String kieuPhi, String noiDung) {
        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPrefHeight(80.0);
        hbox.setPrefWidth(355.5);
        hbox.setStyle("-fx-background-color: #ccc; -fx-background-radius: 10;");
        Insets hboxPadding = new Insets(18);
        hbox.setPadding(hboxPadding);
        VBox vbox = initVBox(kieuPhi, mucPhi, tieudePhi);
        hbox.getChildren().addAll(vbox);

        hbox.setId(idHBox);
        vbox.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                // Gọi hàm ChiTietThongTin khi click vào VBox
                ChiTietThongTin(vbox);


            }
        });
        return hbox;
    }

    public void ChiTietThongTin(VBox vbox) {
        HBox parentHBox = (HBox) vbox.getParent();
        String idHBox = parentHBox.getId();

        String idPhiString = idHBox;
        Integer idPhi = Integer.parseInt(idPhiString);
        KhoanPhiDAO khoanPhiDAO = new KhoanPhiDAO(connection);
        Optional<KhoanPhi> resultKhoanPhi;
        try {
            resultKhoanPhi = khoanPhiDAO.get(idPhi);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (resultKhoanPhi.isPresent()) {
            KhoanPhi khoanPhi = resultKhoanPhi.get();
            List<String> thongtinKhoanPhi = LayThongTinKhoanPhi(khoanPhi);
            String chitiet = "";
            chitiet = thongtinKhoanPhi.get(1) + "\n\n" + thongtinKhoanPhi.get(2) + "\n\n" + thongtinKhoanPhi.get(3) + "\n\n" + thongtinKhoanPhi.get(4) + "\n\n" + thongtinKhoanPhi.get(5) + "\n\n";

            hienThiChiTiet.setText(chitiet);
        }

    }


    public List<String> LayThongTinKhoanPhi(KhoanPhi khoanPhi) {
        List<String> thongtinKhoanPhi = new ArrayList<>();
        String idHBox = String.valueOf(khoanPhi.getIdPhi());
        String idPhi = "Id phí: " + khoanPhi.getIdPhi();
        String mucPhi = "Mức phí: " + khoanPhi.getMucphi();
        String tieudePhi = "Tiêu dề phí: " + khoanPhi.getTieudephi();
        String kieuPhi = "Kiểu phí: " + khoanPhi.getKieuphi();
        String noiDUng = "Nội dung: " + "\n" + khoanPhi.getNoidungphi();
        thongtinKhoanPhi.add(idHBox);
        thongtinKhoanPhi.add(idPhi);
        thongtinKhoanPhi.add(mucPhi);
        thongtinKhoanPhi.add(tieudePhi);
        thongtinKhoanPhi.add(kieuPhi);
        thongtinKhoanPhi.add(noiDUng);
        return thongtinKhoanPhi;


    }

    public List<String> LayThongTinDongPhi(DongPhi dongPhi) {
        List<String> thongtinDongPhi = new ArrayList<>();
        String idHBox = String.valueOf(dongPhi.getIdPhi());
        String idPhi = "ID Phí: " + dongPhi.getIdPhi();
        String idHoKhau = "ID Hộ Khẩu: " + dongPhi.getIdHoKhau();
        String soTien = "Số Tiền : " + dongPhi.getSoTien();
        String ngaydong = "Ngày đóng: " + dongPhi.getNgayDong();
        thongtinDongPhi.add(idHBox);
        thongtinDongPhi.add(idPhi);
        thongtinDongPhi.add(idHoKhau);
        thongtinDongPhi.add(soTien);
        thongtinDongPhi.add(ngaydong);
        return thongtinDongPhi;
    }

    @FXML
    public void timkiem(ActionEvent event) {
        String yeucautimkiem = noidungtim.getText();
        if (!yeucautimkiem.isEmpty()) {
            VBoxList.getChildren().clear();
            VBoxList.getChildren().add(hBoxTimKiem);
            for (HBox hbox : danhsachHBox) {
                for (var nodeHbox : hbox.getChildren()) {
                    if (nodeHbox instanceof VBox vbox) {
                        for (var nodeVbox : vbox.getChildren()) {
                            if (nodeVbox instanceof Label label) {
                                if (label.getText().toLowerCase().contains(yeucautimkiem.toLowerCase())) {
                                    VBoxList.getChildren().add(hbox);
                                    break;
                                }
                            }
                        }
                        break;
                    }

                }
            }
        } else {
            VBoxList.getChildren().clear();
            VBoxList.getChildren().add(hBoxTimKiem);
            for (HBox hbox : danhsachHBox) {
                VBoxList.getChildren().add(hbox);
            }
        }

    }

    @FXML
    public void timkiemnoptien(ActionEvent event) {
        String yeucautimkiemnoptien = noidungtimnoptien.getText();
        if (!yeucautimkiemnoptien.isEmpty()) {
            VBoxdanhsachnoptien.getChildren().clear();
            VBoxdanhsachnoptien.getChildren().add(hBoxtiemkiemnoptien);
            for (HBox hbox : danhsachHoxdongphi) {
                for (var nodeHbox : hbox.getChildren()) {
                    if (nodeHbox instanceof VBox vbox) {
                        for (var nodeVbox : vbox.getChildren()) {
                            if (nodeVbox instanceof Label label) {
                                if (label.getText().toLowerCase().contains(yeucautimkiemnoptien.toLowerCase())) {
                                    VBoxdanhsachnoptien.getChildren().add(hbox);
                                    break;
                                }
                            }
                        }
                        break;
                    }

                }
            }
        } else {
            VBoxdanhsachnoptien.getChildren().clear();
            VBoxdanhsachnoptien.getChildren().add(hBoxtiemkiemnoptien);
            for (HBox hbox : danhsachHoxdongphi) {
                VBoxdanhsachnoptien.getChildren().add(hbox);
            }
        }

    }


}
