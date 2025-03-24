package org.example.demoweek10inclass;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

import java.io.FileNotFoundException;

public class EmailListController {
    @FXML
    private Button buttonWeek10;

    @FXML
    private Label welcomeText;
    @FXML
    private Label titleText;

    @FXML
    protected void onHelloButtonClick() throws FileNotFoundException {
        String email = EmailList.getFirstEmail();
        welcomeText.setText("Welcome to JavaFX Application!"+email);
        buttonWeek10.setText("Click Me!");
    }

    @FXML
    protected void onNewButtonClick() {
        titleText.setText("Week 11 task:");
    }
}