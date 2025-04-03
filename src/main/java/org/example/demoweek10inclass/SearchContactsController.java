package org.example.demoweek10inclass;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

public class SearchContactsController implements Initializable {

    @FXML
    private TableColumn<Contact, String> colEmail;

    @FXML
    private TableColumn<Contact, String> colFirstName;

    @FXML
    private TableColumn<Contact, String> colLastName;

    @FXML
    private TextField filterText;


    @FXML
    private TableView<Contact> tableContacts;

    private ObservableList<Contact> contacts;
    private FilteredList<Contact> filteredContacts;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Initializing SearchContactsController");
        //Get all contacts into contacts
        try {
            contacts = FXCollections.observableArrayList(EmailList.getAllContacts());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        //FilteredList binding to the tableview
        filteredContacts = new FilteredList<Contact>(contacts);
        tableContacts.setItems(filteredContacts);
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        colLastName.setCellValueFactory(new PropertyValueFactory<>("lastName"));

        //Add listener for the keyword textbox
        filterText.textProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println(newValue);
            //change the filtered list
            filteredContacts.setPredicate(c->
            {
                System.out.println(c.toString());
                return c.toString().toLowerCase().contains(newValue.toLowerCase());
            });
        });
    }

    public void refreshTable(ActionEvent actionEvent) throws FileNotFoundException {
        contacts.clear();
        contacts.addAll(EmailList.getAllContacts());
    }
}

