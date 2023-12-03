package com.example.introductiontose.view.icon;

public enum ImageType {
    NHANKHAU_IN_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-100.png"),
    NHANKHAU_OUT_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-gray-100.png"),
    NHANKHAU_IN_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-white-100.png"),
    NHANKHAU_OUT_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-user-100.png"),
    CHUHO_IN_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-9FAAE5-100.png"),
    CHUHO_OUT_SELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-color-100.png"),
    CHUHO_IN_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-customer-white-100.png"),
    CHUHO_OUT_UNSELECTED("/com/example/introductiontose/view/iconImg/icons8-user-color-100.png");
    
    private final String iconPath;
    
    ImageType(String iconPath) {
        this.iconPath = iconPath;
    }
    
    public String getIconPath() {
        return iconPath;
    }
}
