package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

import org.teamone.client.generic.User;

/**
 * Created by daniel on 10/6/15.
 */

@ControllerAdvice
public class NavbarAttributes {

    @ModelAttribute
    public void setNavbar(Map<String, Object> model) {
        User user = new User();
        System.out.println("loading navbar");
        model.put("message", "message");
        model.put("user", user);
        System.out.println(model);
    }
}
