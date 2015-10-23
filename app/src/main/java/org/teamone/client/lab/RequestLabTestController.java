package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.labs.LabTestRequest;

import java.util.Map;

/**
 * Created by daniel on 10/22/15.
 */

@Controller
@Scope("Request")
@RequestMapping(value = "/**/request_test")
public class RequestLabTestController {

    @RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @PathVariable String reportID,
                          @ModelAttribute User user) {
        //they don't say they be who they are, but they don't
        if(!user.getPerson().getOccupation().equals("Lab"))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest request = new LabTestRequest();
        model.put("request", request);
        return "lab/labtestrequest";
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @ModelAttribute User user) {
        //they don't say they be who they are, but they don't
        if(!user.getPerson().getOccupation().equals("Doctor"))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest request = new LabTestRequest();
        model.put("request", request);
        return "lab/labtestrequest";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void submitTest (Map<String, Object> model ) {
        //TODO: submit values to database.
    }
}
