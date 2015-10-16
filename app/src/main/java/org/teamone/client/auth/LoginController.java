package org.teamone.client.auth;

/**
 * Created by daniel on 9/26/15.
 */

//import Spring libs

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.LoginSQL;
import org.teamone.core.users.Person;

import java.util.Map;

@Controller
@Scope("request")
@RequestMapping(value = {"/", "/login"})
public class LoginController {

    @Autowired
    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        LoginAttempt attempt = new LoginAttempt();
        model.put("userInput", attempt);
        System.out.println("loading login");
        return "auth/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processLogin(
            //@ModelAttribute("userInput") LoginAttempt attempt,
            @ModelAttribute("userInput") LoginAttempt attempt,
            @ModelAttribute("user") User user, //special bean used to store session
            Map<String, Object> model) {

        Person pAttempt = new Person();
        pAttempt.setUserID(Integer.parseInt(attempt.getUserID()));
        pAttempt.setPassword(attempt.getPassword());

        if (LoginSQL.authenticate(pAttempt) != null || attempt.getPassword().equals("go")) { //TODO:remove backdoor
            System.out.println("auth succeed");
            //user.setUsername(LoginSQL.getName(pAttempt.getUserID()));
            user.setUsername(pAttempt.getName());
            user.setActions("Left,Left,Left,Right,Left,logout"); //TODO: this field should populate based on user type
            return "redirect:/user/" + user.getUsername();
        } else {
            System.out.println("auth fail");
            String errorMessage = "Your userID or password were incorrect. Try again.";
            model.put("errorMessage", errorMessage);
            return "auth/login";
        }
    }
}

class LoginAttempt {
    private String userID;
    private String password;

    public void setUserID(String username) {
        this.userID = username;
    }

    public String getUserID() {
        return this.userID;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    LoginAttempt(){
    };
}