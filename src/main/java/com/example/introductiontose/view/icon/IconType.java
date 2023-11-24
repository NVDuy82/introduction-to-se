package com.example.introductiontose.view.icon;

public enum IconType {
    NHANKHAU("btn-nhan-khau"),
    CHUHO("btn-chu-ho");
    
    private final String className;
    
    IconType(String className) {
        this.className = className;
    }
    
    public String getClassName() {
        return className;
    }
}
