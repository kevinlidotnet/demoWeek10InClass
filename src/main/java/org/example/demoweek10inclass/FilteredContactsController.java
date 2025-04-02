package org.example.demoweek10inclass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;

public class FilteredContactsController implements Initializable {

        @FXML
        private TableColumn<Contact,String> colEmail;

        @FXML
        private TableColumn<Contact,String> colFirstName;

        @FXML
        private TableColumn<Contact,String> colLastName;

        @FXML
        private TableView<Contact> tableContacts;

        @FXML
        private TextField textFilter;

        private ObservableList<Contact> contacts;
        private FilteredList<Contact> filteredContacts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // Set the cell value factory for each column
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("Email"));

        //Get all contacts
        try {
            contacts = FXCollections.observableList(EmailList.getAllContacts());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        filteredContacts = new FilteredList<>(contacts);
        tableContacts.setItems(filteredContacts);
        //Add filter listener
        textFilter.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredContacts.setPredicate(c-> {
                System.out.println(c.toString());
                System.out.println("Observable property: " + observable);

                return textFilter.getText().isEmpty() ||
                    c.toString().toLowerCase().contains(newValue.toLowerCase());
            });

        });

    }
}




