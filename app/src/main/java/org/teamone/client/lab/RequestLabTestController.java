package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.labs.LabTestRequest;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/22/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/**/request_test")
public class RequestLabTestController {

    @RequestMapping(method= RequestMethod.GET)
    public String list (Map<String, Object> model,
                        @ModelAttribute User user) {
        List labRequestList = new ArrayList<LabTestRequest>(); //TODO: use CORE method.

        LabTestRequest one = new LabTestRequest();
        one.setRequestionID(1);

        LabTestRequest two = new LabTestRequest();
        one.setRequestionID(2);

        labRequestList.add(one);
        labRequestList.add(two);

        model.put("list", labRequestList);
        return "lab/listlabrequests";
    }

    @RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @PathVariable String id,
                          @ModelAttribute User user) {
        //they don't say they be who they are, but they don't
        if(user.getPerson() == null)
            return "redirect:/login";
        if(!user.getPerson().getOccupation().equals("Lab"))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest request = new LabTestRequest(); //TODO: get request from database
        model.put("request", request);
        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @ModelAttribute User user) {
        if(user.getPerson() == null)
            return "redirect:/login";

        LabTestRequest request = new LabTestRequest();
        model.put("request", request);
        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submitTest (Map<String, Object> model ) {
        //TODO: submit values to database.
        return "auth/user"; //TODO: send back to Select Patient.
    }
}
