package com.example.introductiontose.view.icon;

public enum IconType {
    NHANKHAU("/com/example/introductiontose/stylesheet/button-circle-gray.css"),
    CHUHO("/com/example/introductiontose/stylesheet/button-circle-blue.css");
    
    private final String cssPath;
    
    IconType(String cssPath) {
        this.cssPath = cssPath;
    }
    
    public String getCssPath() {
        return cssPath;
    }
}
