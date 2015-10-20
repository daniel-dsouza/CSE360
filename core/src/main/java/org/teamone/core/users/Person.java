package org.teamone.core.users;

/**
 * Created by Ryan on 10/7/2015.
 */


public class Person {
    private String name;
    private String firstName ="";
    private String lastName ="";
    private String occupation;
    private String password;
    private String email;
    private int userID = 0;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
        concatName();
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
        concatName();
    }
    public void concatName()
    {
        name = lastName + firstName;
    }
    public void splitName()
    {
        String[] data = name.split(" ");
        firstName =
        lastName = data[1];
    }
}
