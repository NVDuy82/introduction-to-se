package com.example.introductiontose.util;

import javafx.scene.control.Button;

import java.util.Objects;

public final class ActionButton {
    private static final String btnSubmitHideCss = Objects.requireNonNull(ActionButton.class.getResource("/com/example/introductiontose/stylesheet/button-submit-hidden.css")).toExternalForm();
    private static final String btnSubmitShowCss = Objects.requireNonNull(ActionButton.class.getResource("/com/example/introductiontose/stylesheet/button-submit-show.css")).toExternalForm();
    private static final String btnClearHideCss = Objects.requireNonNull(ActionButton.class.getResource("/com/example/introductiontose/stylesheet/button-clear-hidden.css")).toExternalForm();
    private static final String btnClearShowCss = Objects.requireNonNull(ActionButton.class.getResource("/com/example/introductiontose/stylesheet/button-clear-show.css")).toExternalForm();
    
    private ActionButton() {
    }
    
    public static void showButtonSubmit(Button button) {
        button.getStylesheets().clear();
        button.getStylesheets().add(btnSubmitShowCss);
    }
    
    public static void hideButtonSubmit(Button button) {
        button.getStylesheets().clear();
        button.getStylesheets().add(btnSubmitHideCss);
    }
    
    public static void showButtonClear(Button button) {
        button.getStylesheets().clear();
        button.getStylesheets().add(btnClearShowCss);
    }
    
    public static void hideButtonClear(Button button) {
        button.getStylesheets().clear();
        button.getStylesheets().add(btnClearHideCss);
    }
}
