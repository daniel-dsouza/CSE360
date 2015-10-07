package org.teamone.client.auth;

/**
 * Created by daniel on 9/26/15.
 */

//import Spring libs
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

import org.teamone.client.generic.User;

@Controller
@RequestMapping(value = "/")
public class LoginController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewLogin(Map<String, Object> model) {
        User userInput = new User();
        model.put("userInput", userInput);
        System.out.println("loading login");
        System.out.println(model);
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void processLogin(
            @ModelAttribute("userInput") User user,
            Map<String, Object> model) {
        System.out.println(user.getUsername());
        System.out.println(user.getPassword());
        System.out.println(model);
        //more code
    }

}
