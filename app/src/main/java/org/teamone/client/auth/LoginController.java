package org.teamone.client.auth;

/**
 * Created by daniel on 9/26/15.
 */

//import Spring libs
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import org.springframework.web.bind.annotation.SessionAttributes;
import org.teamone.client.generic.User;

@Controller
@Scope("request")
@RequestMapping(value = {"/", "/login"})
public class LoginController {

    @Autowired
    private User user;

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        //User userInput = new User();
        LoginAttempt attempt = new LoginAttempt();
        model.put("userInput", attempt);
        System.out.println("loading login");
        return "auth/login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String processLogin(
            @ModelAttribute("userInput") LoginAttempt attempt,
            Map<String, Object> model) {
        System.out.println(attempt.getUsername());
        System.out.println(attempt.getPassword());
        System.out.println(model);
        //more code
        if(attempt.getPassword().equals("go")) {
            System.out.println("auth succeed");
            //User user = new User();
            user.setUsername(attempt.getUsername());
            user.setActions("Left,Left,Left,Right,Left,logout");
            model.put("userObj", user);
            return "redirect:/user/" + user.getUsername();
        }
        else {
            System.out.println("auth fail");
            String errorMessage = "you suck";
            model.put("errorMessage", errorMessage);
            return "auth/login";
        }
    }

}

class LoginAttempt {
    private String username;
    private String password;


    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsername() {
        return this.username;
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
