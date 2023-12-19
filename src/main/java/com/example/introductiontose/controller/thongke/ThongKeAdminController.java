//package com.example.introductiontose.controller.thongke;
//
//import com.example.introductiontose.dao.DongPhiDAO;
//import com.example.introductiontose.dao.KhoanPhiDAO;
//import com.example.introductiontose.model.DongPhi;
//import javafx.fxml.Initializable;
//import javafx.scene.chart.XYChart;
//
//import java.sql.SQLException;
//import java.time.YearMonth;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ThongKeAdminController implements Initializable {
//    private DongPhiDAO dongPhiDAO;
//    private List<DongPhi> danhSachDongPhi;
//
//    private void getDanhSachDongPhi() {
//        try {
//            this.dongPhiDAO = new DongPhiDAO(connection);
//            danhSachDongPhi = dongPhiDAO.getAll();
//        }
//        catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//
//    private List<XYChart.Data<String, Number>> thuPhiData = new ArrayList<>();
//    private List<XYChart.Data<String, Number>> dongGopData = new ArrayList<>();
//
//    public void thongKeThuPhi() {
//        Map<YearMonth, Integer> thongKeTP = new HashMap<>();
//        Map<YearMonth, Integer> thongKeDG = new HashMap<>();
//
//        KhoanPhiDAO khoanPhiDAO = new KhoanPhiDAO(connection);
//        Map<Integer, String> danhSachKP = khoanPhiDAO.getDanhSachKhoanPhi();
//
//
//        int soTien;
//        YearMonth thang;
//
//        for (DongPhi dongPhi : danhSachDongPhi) {
//            thang = YearMonth.from(dongPhi.getNgayDong());
//            soTien = dongPhi.getSoTien();
//
//            try {
//                if (danhSachKP.get(dongPhi.getIdPhi()) == null) {
//                    System.out.println("Khoan phi null");
//                } else if (danhSachKP.get(dongPhi.getIdPhi()).equals("bắt buộc")) {
//                    //System.out.println("bb");
//                    thongKeTP.merge(thang, soTien, Integer::sum);
//                } else if (danhSachKP.get(dongPhi.getIdPhi()).equals("đóng góp")) {
//                    //System.out.println("đg");
//                    thongKeDG.merge(thang, soTien, Integer::sum);
//                }
//            }
//            catch (Exception e) {
//                //
//            }
//        }
//
//        thongKeTP.forEach((month, tongTien) -> {
//            thuPhiData.add(new XYChart.Data<>(month.toString(), tongTien));
//        });
//
//        thongKeDG.forEach((month, tongTien) -> {
//            dongGopData.add(new XYChart.Data<>(month.toString(), tongTien));
//        });
//    }
//}
