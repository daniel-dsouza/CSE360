package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;

import java.util.Map;

/**
 * Created by daniel on 10/24/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="/**/lab_report")
public class LabTestController {

    @RequestMapping(value="/{id}/view", method= RequestMethod.GET)
    public String viewGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "login/login";

        return "lab/viewlabreport";
    }

    @RequestMapping(value="/{id}/edit", method= RequestMethod.GET)
    public String editGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{id}/edit", method= RequestMethod.POST)
    public String editPost (Map<String, Object> model,
                            @PathVariable String reportID,
                            @ModelAttribute User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{id}/create", method= RequestMethod.GET)
    public String createGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{id}/create", method= RequestMethod.POST)
    public String createPost (Map<String, Object> model,
                             @PathVariable String reportID,
                             @ModelAttribute User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(method= RequestMethod.GET)
    public String list (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute User user) {

        return "lab/listlabreport";
    }
}
