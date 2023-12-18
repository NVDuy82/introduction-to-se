package com.example.introductiontose.controller.trangchu;

import com.example.introductiontose.dao.DongPhiDAO;
import com.example.introductiontose.dao.KhoanPhiDAO;
import com.example.introductiontose.dao.ThongTinTDPDAO;
import com.example.introductiontose.model.DongPhi;
import com.example.introductiontose.model.ThongTinTDP;
import com.example.introductiontose.util.AlertUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.chart.BarChart;

import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.YearMonth;
import java.util.*;

public class TrangChuUserController implements Initializable {
    @FXML
    private Label tenUser;
    @FXML
    private Label tenHoKhau;
    @FXML
    private Label tienDu;
    @FXML
    private Label tienChuaDong;
    @FXML
    private Label soNhanKhau;

    @FXML
    private HBox hoKhau, duTK, chuaDong;
    @FXML
    private BarChart bangThongKe;
    @FXML
    private VBox danhSachYeuCau;
    Connection connection;

    private ThongTinTDP thongTin;

    public void getThongTinUser () {
        ThongTinTDPDAO ketNoi = new ThongTinTDPDAO(connection);
        try {
            thongTin = ketNoi.get();
        } catch (Exception e) {
            AlertUtils.showAlert("Lỗi", "Đã có lỗi khi gửi yêu cầu này.");
        }
    }

    private DongPhiDAO dongPhiDAO;
    private List<DongPhi> danhSachDongPhi;

    private void getDanhSachDongPhi() {
        try {
            this.dongPhiDAO = new DongPhiDAO(connection);
            danhSachDongPhi = dongPhiDAO.getAll();
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }

    private List<XYChart.Data<String, Number>> thuPhiData = new ArrayList<>();
    private List<XYChart.Data<String, Number>> dongGopData = new ArrayList<>();

    public void thongKeThuPhi() {
        Map<YearMonth, Integer> thongKeTP = new HashMap<>();
        Map<YearMonth, Integer> thongKeDG = new HashMap<>();

        KhoanPhiDAO khoanPhiDAO = new KhoanPhiDAO(connection);
        Map<Integer, String> danhSachKP = khoanPhiDAO.getDanhSachKhoanPhi();


        int soTien;
        YearMonth thang;

        for (DongPhi dongPhi : danhSachDongPhi) {
            thang = YearMonth.from(dongPhi.getNgayDong());
            soTien = dongPhi.getSoTien();

            try {
                if (danhSachKP.get(dongPhi.getIdPhi()) == null) {
                    System.out.println("Khoan phi null");
                } else if (danhSachKP.get(dongPhi.getIdPhi()).equals("bắt buộc")) {
                    //System.out.println("bb");
                    thongKeTP.merge(thang, soTien, Integer::sum);
                } else if (danhSachKP.get(dongPhi.getIdPhi()).equals("đóng góp")) {
                    //System.out.println("đg");
                    thongKeDG.merge(thang, soTien, Integer::sum);
                }
            }
            catch (Exception e) {
                //
            }
        }

        thongKeTP.forEach((month, tongTien) -> {
            thuPhiData.add(new XYChart.Data<>(month.toString(), tongTien));
        });

        thongKeDG.forEach((month, tongTien) -> {
            dongGopData.add(new XYChart.Data<>(month.toString(), tongTien));
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Khởi tạo hoặc cấu hình ban đầu cho các phần tử giao diện
        // Ví dụ: cập nhật dữ liệu từ cơ sở dữ liệu, cấu hình sự kiện, v.v.
    }

    // Các phương thức xử lý sự kiện, cập nhật giao diện, v.v.
}
