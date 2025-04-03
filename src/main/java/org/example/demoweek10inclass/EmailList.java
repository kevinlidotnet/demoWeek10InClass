package org.example.demoweek10inclass;

import jdk.dynalink.beans.StaticClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmailList {
    static String getFirstEmail() throws FileNotFoundException {
        String Email="";
        try(Scanner in = new Scanner(new File("src/main/resources/org/example/demoweek10inclass/contacts.csv"));)
        {
            while(in.hasNext()){
                String contact = in.nextLine();
                if (contact.contains("@")) {
                    Contact c = new Contact(contact.substring(0, contact.indexOf(",")),
                            contact.substring(contact.indexOf(",") + 1,contact.lastIndexOf(",")),
                            contact.substring(contact.lastIndexOf(",") + 1));
                    return c.getEmail();
                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Email;
    }

    static ArrayList<String> getAllEmails() throws FileNotFoundException {
        ArrayList<String> Emails= new ArrayList<>();
        try(Scanner in = new Scanner(new File("src/main/resources/org/example/demoweek10inclass/contacts.csv"));)
        {
            while(in.hasNext()){
                String contact = in.nextLine();
                if (contact.contains("@")) {
                    Contact c = new Contact(contact.substring(0, contact.indexOf(",")),
                            contact.substring(contact.indexOf(",") + 1,contact.lastIndexOf(",")),
                            contact.substring(contact.lastIndexOf(",") + 1));
                    Emails.add( c.getEmail());
                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return Emails;
    }

    static ArrayList<Contact> getAllContacts() throws FileNotFoundException {
        ArrayList<Contact> contacts= new ArrayList<>();
        try(Scanner in = new Scanner(new File("src/main/resources/org/example/demoweek10inclass/contacts.csv"));)
        {
            while(in.hasNext()){
                String contact = in.nextLine();
                if (contact.contains("@")) {
                    Contact c = new Contact(contact.substring(0, contact.indexOf(",")),
                            contact.substring(contact.indexOf(",") + 1,contact.lastIndexOf(",")),
                            contact.substring(contact.lastIndexOf(",") + 1));
                    contacts.add( c);
                }

            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return contacts;
    }

}
