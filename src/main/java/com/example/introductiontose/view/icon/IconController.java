package com.example.introductiontose.view.icon;

import com.example.introductiontose.model.NhanKhau;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.ResourceBundle;

public abstract class IconController<T> implements Initializable {
    @FXML
    protected Button buttonIcon;
    @FXML
    protected ImageView imageIcon;
    protected boolean isSelected = false;
    protected IconType iconType;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setIconType(IconType.NHANKHAU);
    }
    
    public void setIconType(IconType iconType) {
        this.iconType = iconType;
        setCssButton(iconType);
        mouseEffect();
    }
    
    abstract public void setData(T t);
    
    public void setSelected(boolean selected) {
        isSelected = selected;
        mouseEffect();
    }
    
    abstract public T getData();
    
    public boolean isSelected() {
        return isSelected;
    }
    
    abstract public void mouseEffect();
    
    private void setCssButton(IconType iconType) {
        // Xóa tất cả các style class hiện tại
        buttonIcon.getStyleClass().clear();
        
        // Set Css
        buttonIcon.getStyleClass().add(iconType.getClassName());
    }
    
    protected Image imageFromResourceAsStream(String name) {
        return new Image(Objects.requireNonNull(getClass().getResourceAsStream(name)));
    }
}
