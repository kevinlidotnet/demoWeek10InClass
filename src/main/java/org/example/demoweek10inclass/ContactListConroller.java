package org.example.demoweek10inclass;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Objects;
import java.util.ResourceBundle;

public class ContactListConroller implements Initializable {

    @FXML
    private ListView<String> contactListView;

    @FXML
    private Label totalContacts;


    @FXML
    private TextField keyword;

    private ObservableList<String> list    ;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Get all the emails and show them in the contact listview
        try {
            ArrayList<String> emails = EmailList.getAllEmails();
            ObservableList<String> items = contactListView.getItems();
            for (String email : emails) {
                items.add(email);
            }
            contactListView.setItems(items);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        list = contactListView.getItems();
        list.addListener((InvalidationListener) observable -> {
            System.out.println(list.size());
        });

        //To show the total number of the contacts
        totalContacts.setText(String.valueOf(contactListView.getItems().stream().count()));
    }

    public void SearchEmails() throws FileNotFoundException {
        //check the text field and filter the list
        String emailKeyword= keyword.getText();
        ArrayList<String> emails = EmailList.getAllEmails();
        ObservableList<String> items = contactListView.getItems();
        for (String email : emails) {
            if (!email.contains(emailKeyword))
             items.remove(email);
        }
        contactListView.setItems(items);
        //To show the total number of the contacts
        totalContacts.setText(String.valueOf(contactListView.getItems().stream().count()));

    }
}
