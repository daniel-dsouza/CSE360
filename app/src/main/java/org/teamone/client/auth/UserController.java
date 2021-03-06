package org.teamone.client.auth;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;

import java.util.Map;

/**
 * Created by daniel on 10/7/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/user/")
public class UserController {

    @RequestMapping(value = "{userID}", method = RequestMethod.GET)
    public String view2(
            Map<String, Object> model,
            @PathVariable String userID,
            @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        System.out.println("Load User Home");
        return "auth/user";
    }


    @RequestMapping(method = RequestMethod.GET)
    public String viewUserHome(
            Map<String, Object> model,
            @ModelAttribute User user) {
        //redirect to correct page.

        return "redirect:/login";
    }
}
