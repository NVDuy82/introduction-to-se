package com.example.introductiontose.controller.thongke;

import com.example.introductiontose.dao.*;
import com.example.introductiontose.database.SqlConnection;
import com.example.introductiontose.model.DongPhi;
import com.example.introductiontose.model.HoKhau;
import com.example.introductiontose.model.NhanKhauDaThem;
import com.example.introductiontose.model.ThongTinTDP;
import com.example.introductiontose.util.AlertUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.sql.Connection;
import java.time.YearMonth;
import java.util.*;

public class ThongKeNKAdminController implements Initializable {
    @FXML
    private Label tenTDP;

    @FXML
    private Label soHoKhau;

    @FXML
    private Label soNhanKhau;

    @FXML
    private BarChart thongKeChart;

    @FXML
    private Label tkSoLuong;

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
        Map<YearMonth, Integer> thongKeHoKhauTheoThang = new HashMap<>();
        Map<YearMonth, Integer> thongKeNhanKhauTheoThang = new HashMap<>();

        HoKhauDAO hoKhauDAO = new HoKhauDAO(connection);
        NhanKhauDaThemDAO nhanKhauDaThemDAO = new NhanKhauDaThemDAO(connection); // Giả định bạn có class này

        try {
            List<HoKhau> danhSachHoKhau = hoKhauDAO.getAll();
            List<NhanKhauDaThem> danhSachNhanKhau = nhanKhauDaThemDAO.getAll(); // Giả định phương thức này tồn tại

            // Thống kê số lượng hộ khẩu theo tháng
            for (HoKhau hoKhau : danhSachHoKhau) {
                YearMonth thang = YearMonth.from(hoKhau.getNgayTaoHK());
                thongKeHoKhauTheoThang.merge(thang, 1, Integer::sum);
            }

            // Thống kê số lượng nhân khẩu theo tháng
            for (NhanKhauDaThem nhanKhau : danhSachNhanKhau) {
                YearMonth thang = YearMonth.from(nhanKhau.getNgayThem());
                thongKeNhanKhauTheoThang.merge(thang, 1, Integer::sum);
            }

            // Tiếp theo, bạn có thể sử dụng dữ liệu thống kê để cập nhật vào biểu đồ hoặc hiển thị trên giao diện
        } catch (Exception e) {
            e.printStackTrace();
            // Xử lý lỗi hoặc thông báo lỗi
        }

        thongKeHoKhauTheoThang.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> hoKhauData.add(new XYChart.Data<>(entry.getKey().toString(), entry.getValue())));

        thongKeNhanKhauTheoThang.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> nhanKhauData.add(new XYChart.Data<>(entry.getKey().toString(), entry.getValue())));
    }

    public void setBangTK(int check) {
        if(check == 1) {
            XYChart.Series<String, Number> thuPhi = new XYChart.Series<>();
            thuPhi.setName("Nhân khẩu");
            // Thêm dữ liệu vào series
            thuPhi.getData().addAll(nhanKhauData);

            XYChart.Series<String, Number> dongGop = new XYChart.Series<>();
            dongGop.setName("Hộ khẩu");
            // Thêm dữ liệu vào series
            dongGop.getData().addAll(hoKhauData);

            thongKeChart.getData().addAll(thuPhi, dongGop);
        }
        else {

        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.connection = SqlConnection.connect();

        // Khởi tạo dữ liệu và cài đặt ban đầu cho các thành phần
        getThongTinTDP();
        setThongTinTDP();

        thongKeNK();
        setBangTK(1);


        SqlConnection.close(connection);
    }
}
