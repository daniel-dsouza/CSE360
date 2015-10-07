package org.teamone.client.generic;

/**
 * Created by daniel on 9/26/15.
 */

//import Spring libs
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        User userInput = new User();
        model.put("userInput", userInput);
        System.out.println("loading login");
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void processLogin(
            @ModelAttribute("userInput") User user,
            Map<String, Object> model) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        //more code
    }

}

class User {
    public String username;
    public String password;

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
}
