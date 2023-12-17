package com.example.introductiontose.controller.admin.naptien;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

/**
 * Node hiển thị thông tin nạp tiền trong giao diện admin.
 *
 * <p>Node này là một thành phần của giao diện, thể hiện thông tin cần nhập tiền cho một người dùng.</p>
 *
 * <p>Node này được tạo bằng cách sử dụng một file FXML để định nghĩa cấu trúc và giao diện của nó.</p>
 *
 * <p>Thông tin hiển thị bao gồm số CCCD, tên, số tiền cần nạp, và ghi chú.</p>
 *
 * @author Duy
 * @version 1.0
 */
public class NapTienNode extends HBox {
    @FXML
    private Label cccd;
    
    @FXML
    private Label ghiChu;
    
    @FXML
    private Label money;
    
    @FXML
    private Label name;
    
    /**
     * Constructor của NapTienNode.
     *
     * @param soCccd Số CCCD của người cần nạp tiền.
     * @param name Tên của người cần nạp tiền.
     * @param money Số tiền cần nạp.
     * @param ghiChu Ghi chú liên quan đến nạp tiền.
     */
    public NapTienNode(String soCccd, String name, int money, String ghiChu) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/example/introductiontose/view/admin/NapTienNode.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        
        this.cccd.setText(soCccd);
        this.name.setText(name);
        this.money.setText(String.valueOf(money));
        this.ghiChu.setText(ghiChu);
    }
    
    /**
     * Xử lý sự kiện khi nút "Hủy" được nhấn.
     *
     * @param event Sự kiện nhấn nút "Hủy".
     */
    @FXML
    void cancel(ActionEvent event) {
        // Xử lý logic khi hủy nạp tiền (có thể thêm code theo yêu cầu cụ thể).
    }
    
    /**
     * Xử lý sự kiện khi nút "Nạp tiền" được nhấn.
     *
     * @param event Sự kiện nhấn nút "Nạp tiền".
     */
    @FXML
    void submit(ActionEvent event) {
        // Xử lý logic khi xác nhận nạp tiền (có thể thêm code theo yêu cầu cụ thể).
    }
}
