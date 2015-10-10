package org.teamone.client.auth;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by daniel on 10/7/15.
 */

@Controller
@Scope("request")
public class UserController {

    //@Autowired
    //private User user;

    @RequestMapping(value = "/user/{userID}", method = RequestMethod.GET)
    public String viewUserHome(
            Map<String, Object> model,
            @PathVariable String userID) {
        //model.put("user", user);
        System.out.println("load User?");
        System.out.println(model);
        //System.out.println(user);
        //System.out.println(user.getUsername());
        System.out.println(userID);
        return "auth/user";
    }
}
