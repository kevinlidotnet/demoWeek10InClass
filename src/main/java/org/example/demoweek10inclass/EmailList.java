package org.example.demoweek10inclass;

import java.io.File;
import java.io.FileNotFoundException;
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
}
