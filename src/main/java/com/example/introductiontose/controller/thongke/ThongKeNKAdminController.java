package com.example.introductiontose.controller.thongke;

import com.example.introductiontose.dao.*;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.*;
import com.example.introductiontose.util.AlertUtils;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.*;
import javafx.scene.control.Label;
import javafx.scene.control.MenuButton;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.time.LocalDate;
import java.time.Period;
import java.time.YearMonth;
import java.util.*;

import static java.lang.Math.min;

public class ThongKeNKAdminController implements Initializable {
    @FXML
    private Label tenTDP;

    @FXML
    private Label soHoKhau;

    @FXML
    private Label soNhanKhau;

    private BarChart soLuongNKChart;
    private BarChart soLuongHKChart;
    private PieChart gioiTinhChart;
    private PieChart doTuoiChart;

    @FXML
    private Pane thongKeChart;

    @FXML
    private MenuButton tkSoLuong;

    @FXML
    private Label tkGioiTinh;

    @FXML
    private Label tkDoTuoi;

    @FXML
    private Label tenDanhSach;

    @FXML
    private VBox danhSachNKHK;

    @FXML
    private VBox xemTatCaDS;

    @FXML
    private VBox lichSu;

    @FXML
    private VBox xemTatCaLS;

    @FXML
    public void onNhanKhauClicked() {
        setBangTK(1);
    }
    @FXML
    public void onHoKhauClicked() {
        setBangTK(4);
    }

    @FXML
    public void onTKDoTuoiClicked() {
        setBangTK(3);
    }

    @FXML
    public void onTKGioiTinhClicked() {
        setBangTK(2);
    }

    Connection connection;
    private ThongTinTDP thongTin;

    public void getThongTinTDP () {
        ThongTinTDPDAO ketNoi = new ThongTinTDPDAO(connection);
        try {
            thongTin = ketNoi.get();
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }

    public void setThongTinTDP () {
        tenTDP.setText(thongTin.getTen());
        soHoKhau.setText(thongTin.getSoHoKhau());
        soNhanKhau.setText(thongTin.getSoNhanKhau());
    }


    private List<XYChart.Data<String, Number>> nhanKhauData = new ArrayList<>();
    private List<XYChart.Data<String, Number>> hoKhauData = new ArrayList<>();
    public void thongKeNK() {
        Map<String, Integer> thongKeNhanKhauTheoThang = new LinkedHashMap<>();

        NhanKhauDAO nhanKhauDAO = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);
        NhanKhauDaThemDAO nhanKhauDaThemDAO = new NhanKhauDaThemDAO(connection);
        ThayDoiNhanKhauDao thayDoiNhanKhauDAO = new ThayDoiNhanKhauDao(connection);

        try {
            List<NhanKhau> danhSachNhanKhau = nhanKhauDAO.getAll();
            int tongSoNhanKhau = danhSachNhanKhau.size();
            List<NhanKhauDaThem> danhSachNhanKhauDaThem = nhanKhauDaThemDAO.getAll();

            List<ThayDoiNhanKhau> danhSachThayDoiNK = thayDoiNhanKhauDAO.getDaThayDoi();

            // Khởi tạo số lượng nhân khẩu cho mỗi tháng
            YearMonth thangHienTai = YearMonth.now();

            for (int i = 5; i >= 0; i--) {
                YearMonth thang = thangHienTai.minusMonths(i);
                String tenThang = "Tháng " + thang.getMonthValue() + "/" + thang.getYear();
                thongKeNhanKhauTheoThang.put(tenThang, tongSoNhanKhau);
            }

            // Trừ đi những nhân khẩu chuyển đi hoặc mất
            for (ThayDoiNhanKhau thayDoiNhanKhau : danhSachThayDoiNK) {
                YearMonth thangThayDoiNhanKhau = YearMonth.from(thayDoiNhanKhau.getNgaychuyendi());
                if (thangThayDoiNhanKhau.isBefore(thangHienTai) || thangThayDoiNhanKhau.equals(thangHienTai)) {
                    for (int i = 5; i >= 0; i--) {
                        YearMonth thangIndex = thangHienTai.minusMonths(i);
                        String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
                        // Kiểm tra nếu tháng trong danh sách là sau hoặc bằng tháng của nhân khẩu
                        if (thangIndex.isAfter(thangThayDoiNhanKhau) || thangIndex.equals(thangThayDoiNhanKhau)) {
                            thongKeNhanKhauTheoThang.put(tenThangIndex, thongKeNhanKhauTheoThang.get(tenThangIndex) - 1);
                        }
                        else {
                            thongKeNhanKhauTheoThang.put(tenThangIndex, thongKeNhanKhauTheoThang.get(tenThangIndex) + 1);
                        }
                    }
                }
            }

//            for (int i = 0; i < 5; i++) {
//                YearMonth thangIndex = thangHienTai.minusMonths(i);
//                YearMonth thangTruoc = thangHienTai.minusMonths(i + 1);
//                String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
//                String tenThangTruoc = "Tháng " + thangTruoc.getMonthValue() + "/" + thangTruoc.getYear();
//                int soLuongThangIndex = thongKeNhanKhauTheoThang.getOrDefault(tenThangIndex, tongSoNhanKhau);
//                int soLuongThangTruoc = thongKeNhanKhauTheoThang.getOrDefault(tenThangTruoc, tongSoNhanKhau);
//
//                thongKeNhanKhauTheoThang.put(tenThangTruoc, Math.min(soLuongThangTruoc, soLuongThangIndex));
//            }

            // Trừ đi những nhân khẩu được thêm từ các tháng trước
            for (NhanKhauDaThem nhanKhau : danhSachNhanKhauDaThem) {
                YearMonth thangNhanKhau = YearMonth.from(nhanKhau.getNgayThem());
                if (thangNhanKhau.isBefore(thangHienTai) || thangNhanKhau.equals(thangHienTai)) {
                    for (int i = 5; i >= 0; i--) {
                        YearMonth thangIndex = thangHienTai.minusMonths(i);
                        // Kiểm tra nếu tháng trong danh sách là sau hoặc bằng tháng của nhân khẩu
                        if (thangIndex.isBefore(thangNhanKhau) || thangIndex.equals(thangNhanKhau)) {
                            String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
                            thongKeNhanKhauTheoThang.put(tenThangIndex, thongKeNhanKhauTheoThang.get(tenThangIndex) - 1);
                        }
                    }
                }
            }

//            for (int i = 0; i < 5; i++) {
//                YearMonth thangIndex = thangHienTai.minusMonths(i);
//                YearMonth thangTruoc = thangHienTai.minusMonths(i + 1);
//                String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
//                String tenThangTruoc = "Tháng " + thangTruoc.getMonthValue() + "/" + thangTruoc.getYear();
//                int soLuongThangIndex = thongKeNhanKhauTheoThang.getOrDefault(tenThangIndex, tongSoNhanKhau);
//                int soLuongThangTruoc = thongKeNhanKhauTheoThang.getOrDefault(tenThangTruoc, tongSoNhanKhau);
//
//                thongKeNhanKhauTheoThang.put(tenThangTruoc, Math.min(soLuongThangTruoc, soLuongThangIndex));
//            }
            // Cập nhật dữ liệu biểu đồ
            nhanKhauData.clear();
            thongKeNhanKhauTheoThang.forEach((tenThang, soLuong) -> nhanKhauData.add(new XYChart.Data<>(tenThang, soLuong)));
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi hoặc thông báo lỗi
        }

        Map<String, Integer> thongKeHoKhauTheoThang = new LinkedHashMap<>();

        HoKhauDAO hoKhauDAO = new HoKhauDAO(connection);

        try {
            List<HoKhau> danhSachHoKhau = hoKhauDAO.getAll();

            int tongHoKhau = danhSachHoKhau.size();

            // Khởi tạo số lượng hộ khẩu cho mỗi tháng
            YearMonth thangHienTai = YearMonth.now();
            for (int i = 5; i >= 0; i--) {
                YearMonth thang = thangHienTai.minusMonths(i);
                String tenThang = "Tháng " + thang.getMonthValue() + "/" + thang.getYear();
                thongKeHoKhauTheoThang.put(tenThang, tongHoKhau);
            }

            // Cập nhật số lượng hộ khẩu theo ngày tạo
            for (HoKhau hoKhau : danhSachHoKhau) {
                YearMonth thangHoKhau = YearMonth.from(hoKhau.getNgayTaoHK());
                if (thangHoKhau.isBefore(thangHienTai) || thangHoKhau.equals(thangHienTai)) {
                    for (int i = 5; i >= 0; i--) {
                        YearMonth thangIndex = thangHienTai.minusMonths(i);
                        // Kiểm tra nếu tháng trong danh sách là sau hoặc bằng tháng của nhân khẩu
                        if (thangIndex.isBefore(thangHoKhau) || thangIndex.equals(thangHoKhau)) {
                            String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
                            thongKeHoKhauTheoThang.put(tenThangIndex, thongKeHoKhauTheoThang.get(tenThangIndex) - 1);
                        }
                    }
                }
            }

            for (int i = 0; i < 5; i++) {
                YearMonth thangIndex = thangHienTai.minusMonths(i);
                YearMonth thangTruoc = thangHienTai.minusMonths(i + 1);
                String tenThangIndex = "Tháng " + thangIndex.getMonthValue() + "/" + thangIndex.getYear();
                String tenThangTruoc = "Tháng " + thangTruoc.getMonthValue() + "/" + thangTruoc.getYear();

                int soLuongThangIndex = thongKeHoKhauTheoThang.getOrDefault(tenThangIndex, tongHoKhau);
                int soLuongThangTruoc = thongKeHoKhauTheoThang.getOrDefault(tenThangTruoc, tongHoKhau);

                thongKeHoKhauTheoThang.put(tenThangTruoc, Math.min(soLuongThangTruoc, soLuongThangIndex));
            }
            // Cập nhật dữ liệu biểu đồ
            hoKhauData.clear();
            thongKeHoKhauTheoThang.forEach((tenThang, soLuong) -> hoKhauData.add(new XYChart.Data<>(tenThang, soLuong)));
        }

        catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi hoặc thông báo lỗi
        }

    }

    private int soLuongNam = 0;
    private int soLuongNu = 0;
    private void thongKeGioiTinh() {
        NhanKhauDAO nhanKhauDAO = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);

        try {
            List<NhanKhau> danhSachNhanKhau = nhanKhauDAO.getAll();

            for (NhanKhau nhanKhau : danhSachNhanKhau) {
                if((nhanKhau.getThongTinNhanKhau().getCccd().getSoCccd().charAt(3) - '0') % 2 == 0) {
                    soLuongNam++;
                }
                else {
                    soLuongNu++;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private int soLuongSoSinh;
    private int soLuongTreEm;
    private int soLuongThieuNien;
    private int soLuongThanhNien;
    private int soLuongTrungNien;
    private int soLuongNguoiGia;

    public void thongKeDoTuoi() {
        NhanKhauDAO nhanKhauDAO = new NhanKhauDAO(connection, NhanKhauDAO.TableType.NHANKHAU);

        try {
            List<NhanKhau> danhSachNhanKhau = nhanKhauDAO.getAll();
            LocalDate hienTai = LocalDate.now();

            for (NhanKhau nhanKhau : danhSachNhanKhau) {
                int tuoi = Period.between(nhanKhau.getThongTinNhanKhau().getNgaySinh().toLocalDate(), hienTai).getYears();
                if (tuoi < 6) {
                    soLuongSoSinh++;
                }
                else if (tuoi < 12) {
                    soLuongTreEm++;
                }
                else if (tuoi < 18) {
                    soLuongThieuNien++;
                }
                else if (tuoi < 35) {
                    soLuongThanhNien++;
                } else if (tuoi < 65) {
                    soLuongTrungNien++;
                } else {
                    soLuongNguoiGia++;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    public void setBangTK(int check) {
        if(check == 1) {
            if (soLuongNKChart == null) {
                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Tháng");
                yAxis.setLabel("Số Lượng");

                this.soLuongNKChart = new BarChart<>(xAxis, yAxis);
                this.soLuongNKChart.setMaxHeight(Region.USE_COMPUTED_SIZE);
                this.soLuongNKChart.setMinHeight(Region.USE_COMPUTED_SIZE);
                this.soLuongNKChart.setPrefHeight(345);
                this.soLuongNKChart.setPrefWidth(435);

                XYChart.Series<String, Number> nhanKhau = new XYChart.Series<>();
                nhanKhau.setName("Nhân khẩu");
                // Thêm dữ liệu vào series
                nhanKhau.getData().addAll(nhanKhauData);

                soLuongNKChart.getData().addAll(nhanKhau);
            }

            thongKeChart.getChildren().clear();
            thongKeChart.getChildren().add(soLuongNKChart);
        }
        else if (check == 2){
            if (gioiTinhChart == null) {
                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList(
                                new PieChart.Data("Nam", soLuongNam),
                                new PieChart.Data("Nữ", soLuongNu)
                        );
                gioiTinhChart = new PieChart(pieChartData);

                this.gioiTinhChart.setMaxHeight(Region.USE_COMPUTED_SIZE);
                this.gioiTinhChart.setMinHeight(Region.USE_COMPUTED_SIZE);
                this.gioiTinhChart.setPrefHeight(345);
                this.gioiTinhChart.setPrefWidth(435);
            }

            thongKeChart.getChildren().clear();
            thongKeChart.getChildren().add(gioiTinhChart);
        } else if (check == 3) {
            if(doTuoiChart == null) {
                ObservableList<PieChart.Data> pieChartData =
                        FXCollections.observableArrayList(
                                new PieChart.Data("Sơ sinh (< 6 tuổi)", soLuongSoSinh),
                                new PieChart.Data("Trẻ em (< 12 tuổi)", soLuongTreEm),
                                new PieChart.Data("Thiếu niên (< 18 tuổi)", soLuongThieuNien),
                                new PieChart.Data("Thanh niên (<35 tuổi)", soLuongThanhNien),
                                new PieChart.Data("Trung niên (<65 tuổi)", soLuongTrungNien),
                                new PieChart.Data("Cao tuổi (Trên 65 tuổi)", soLuongNguoiGia)
                        );
                doTuoiChart = new PieChart(pieChartData);

                this.doTuoiChart.setMaxHeight(Region.USE_COMPUTED_SIZE);
                this.doTuoiChart.setMinHeight(Region.USE_COMPUTED_SIZE);
                this.doTuoiChart.setPrefHeight(345);
                this.doTuoiChart.setPrefWidth(435);
            }

            thongKeChart.getChildren().clear();
            thongKeChart.getChildren().add(doTuoiChart);
        } else if (check == 4) {
            if (soLuongHKChart == null) {
                CategoryAxis xAxis = new CategoryAxis();
                NumberAxis yAxis = new NumberAxis();
                xAxis.setLabel("Tháng");
                yAxis.setLabel("Số Lượng");

                this.soLuongHKChart = new BarChart<>(xAxis, yAxis);
                this.soLuongHKChart.setMaxHeight(Region.USE_COMPUTED_SIZE);
                this.soLuongHKChart.setMinHeight(Region.USE_COMPUTED_SIZE);
                this.soLuongHKChart.setPrefHeight(345);
                this.soLuongHKChart.setPrefWidth(435);

                XYChart.Series<String, Number> hoKhau = new XYChart.Series<>();
                hoKhau.setName("Hộ khẩu");
                // Thêm dữ liệu vào series
                hoKhau.getData().addAll(hoKhauData);

                soLuongHKChart.getData().addAll(hoKhau);
            }

            thongKeChart.getChildren().clear();
            thongKeChart.getChildren().add(soLuongHKChart);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.connection = SqlConnection.connect();

        // Khởi tạo dữ liệu và cài đặt ban đầu cho các thành phần
        getThongTinTDP();
        setThongTinTDP();

        thongKeNK();
        thongKeGioiTinh();
        thongKeDoTuoi();

        setBangTK(1);

        SqlConnection.close(connection);
    }
}
