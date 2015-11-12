package org.teamone.client.auth;

/**
 * Created by daniel on 10/7/15.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/logout")
public class LogoutController {

    @RequestMapping(method = RequestMethod.GET)
    public String logout(HttpSession session) {
        System.out.println("ending session and logging out");
        session.invalidate();
        return "redirect:/login";
    }
}