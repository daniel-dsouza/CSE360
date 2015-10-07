package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by daniel on 10/6/15.
 */

@Controller
@RequestMapping("/generic/navbar")
public class NavbarController {

    @Autowired
    public NavbarController() {
        System.out.println("load navbar via autowired.");
    }
    @RequestMapping()
    public String renderNavbar(Map<String, Object> model) {
        System.out.println("loading navbar");
        System.out.println(model);
        return "/generic/navbar";
    }

    @RequestMapping("/index")
    public String toIndex() {
        System.out.println("Send to index");
        return "index";
    }
}
