package org.teamone.client.generic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by daniel on 10/7/15.
 */
@Component
@Scope("session")
public class User {

    private String message = "blahhlahsd";
    private String ID = "001";
    private String username = "";
    private String password;
    public String actions = "logout";

    public void setUsername(String username) {
        this.username = username;
    }
    public String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }
    public void setID(String id) {
        this.ID = id;
    }
    public String getID() {
        return ID;
    }
    public void setActions(String id) {
        this.actions = id;
    }
    public String getActions() {
        return actions;
    }
}