package com.example.introductiontose.controller.trangchu;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class YeuCau extends VBox {

    private Label loaiYeuCau;
    private Label noiDung;

    public YeuCau() {
        // Cài đặt các thuộc tính cho VBox
        this.setMaxHeight(Double.NEGATIVE_INFINITY);
        this.setMinHeight(Double.NEGATIVE_INFINITY);
        this.setPrefHeight(100.0);
        this.setPrefWidth(300.0);
        this.setSpacing(5);
        this.setStyle("-fx-background-radius: 10; -fx-background-color: #BBF7D0;");
        this.setPadding(new Insets(10, 10, 10, 10));
    }

    public void setYeuCauTT(String hoTen, String liDo) {
        Label ten =  new Label(hoTen);
        Label yeuCau = new Label("Tạm trú");
        Label lido = new Label(liDo);
        lido.setWrapText(true);

        this.getChildren().addAll(yeuCau, ten, lido);
    }
    public void setYeuCauTV(String cccd, String liDo) {
        Label ten =  new Label(cccd);
        Label yeuCau = new Label("Tạm vắng");
        Label lido = new Label(liDo);
        lido.setWrapText(true);

        this.getChildren().addAll(yeuCau, ten, lido);
    }
    public void setYeuCauTDHK(String idHoKhau, String noidung) {
        Label ten =  new Label(idHoKhau);
        Label yeuCau = new Label("Thay đổi hộ khẩu");
        Label lido = new Label(noidung);
        lido.setWrapText(true);

        this.getChildren().addAll(yeuCau, ten, lido);
    }
    public void setYeuCauTDNK(String idHoKhau, String noiDung) {
        Label ten =  new Label(idHoKhau);
        Label yeuCau = new Label("Thay đổi nhân khẩu");
        Label lido = new Label(noiDung);
        lido.setWrapText(true);

        this.getChildren().addAll(yeuCau, ten, lido);
    }public void setYeuCauTK(String cccdChuHoMoi, String idHoKhau) {
        Label ten =  new Label(cccdChuHoMoi);
        Label yeuCau = new Label("Tách khẩu");
        Label lido = new Label(idHoKhau);
        lido.setWrapText(true);

        this.getChildren().addAll(yeuCau, ten, lido);
    }

}
