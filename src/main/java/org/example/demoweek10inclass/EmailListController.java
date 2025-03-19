package org.example.demoweek10inclass;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class EmailListController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}