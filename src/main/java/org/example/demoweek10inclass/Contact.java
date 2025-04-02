package org.example.demoweek10inclass;

public class Contact {
    private String firstName;
    private String lastName;
    private String Email;

    Contact(String contactLine){
        firstName = contactLine.substring(0, contactLine.indexOf(","));
        lastName = contactLine.substring(contactLine.indexOf(",") + 1,contactLine.lastIndexOf(","));
        Email = contactLine.substring(contactLine.lastIndexOf(",") + 1);
    }

    Contact(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    @Override
    public String toString(){
        return firstName + " " + lastName + " " + Email;
    }
}
