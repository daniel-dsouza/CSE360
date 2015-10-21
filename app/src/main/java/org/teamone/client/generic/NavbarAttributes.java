package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Map;
import java.util.TreeMap;

/**
 * Created by daniel on 10/6/15.
 */

@ControllerAdvice
@Scope("request")
public class NavbarAttributes {

    @Autowired
    private User user;

    @ModelAttribute
    public void setNavbar(Map<String, Object> model) { //
        System.out.println("loading navbar");
        model.put("message", "message");
        model.put("user", user);
        model.put("pageactions", new TreeMap<String, String>());
        System.out.println(model);
    }
}
