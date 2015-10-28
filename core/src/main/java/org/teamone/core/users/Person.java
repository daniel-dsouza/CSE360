package org.teamone.core.users;

import java.util.Map;
import java.util.TreeMap;

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

    public Map<String, String> agentActions; //action,url
    public Map<String, String> genericActions; //action,url

    public Person() {
        super();
        genericActions = new TreeMap<String, String>();
        genericActions.put("Logout", "logout");
    }

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

    public Map<String, String> getAgentActions() { return agentActions; }

    public void setAgentActions(Map<String, String> agentActions) { this.agentActions = agentActions; }

    public Map<String, String> getGenericActions() { return genericActions; }

    public void setGenericActions(Map<String, String> genericActions) { this.genericActions = genericActions; }

    public String getFirstName() { return firstName; }

    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }

    public void setLastName(String lastName) { this.lastName = lastName; }

    /**
     * //to SQL
     */
    public void toStringName(){
        name = lastName + ":" +firstName;
    }

    /**
     * //from SQL
     * @param nam
     */
    public void splitName(String nam) {
        String[] data = nam.split(":");
        firstName = data[0];
        if (data.length == 2)
            lastName = data[1];
        else
            lastName = "";
    }
}
