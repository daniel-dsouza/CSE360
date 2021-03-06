package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.LabRequestSQL;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.LabStaff;

import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/22/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/**/request_test")
@SessionAttributes("request")
public class RequestLabTestController {

    @RequestMapping(method = RequestMethod.GET)
    public String list(Map<String, Object> model,
                       @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof LabStaff))
            return "redirect:/user/" + user.person.getUserID();

        List labRequestList = LabRequestSQL.getAllLabRequests();
        model.put("list", labRequestList);
        return "lab/listlabrequests";
    }

    @RequestMapping(value = "/{id}/view", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @PathVariable String id,
                          @ModelAttribute User user) {
        //they don't say they be who they are, but they don't
        if (user.getPerson() == null)
            return "redirect:/login";
        if (!(user.getPerson() instanceof LabStaff) && !(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest testID = new LabTestRequest();
        try {
            testID.setRequestionID(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: redirect to error page.
        }

        LabTestRequest request = LabRequestSQL.viewLabRequest(testID);
        model.put("request", request);

        if (request == null) {
            System.out.println(Integer.parseInt(id) + " this returns null");
            return "lab/editlabtestrequest";
        }

        for (String key : request.getLabTestRequest().keySet()) {
            if (request.getLabTestRequest().get(key))
                System.out.println(key + " ");
        }

        model.put("readonly", true);
        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest request = new LabTestRequest();
        model.put("request", request);
        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submitTest(Map<String, Object> model,
                             @ModelAttribute("request") LabTestRequest request,
                             @ModelAttribute("user") User user) {


        //Patient test = new Patient();
        //test.setUserID(1002);
        request.setPatient(user.getPatient());
        request.setPerson(user.getPerson());
        boolean hasOne = true;

        Map<String, Boolean> MapRequest = request.getLabTestRequest();

        for (Map.Entry<String, Boolean> entry : MapRequest.entrySet()) {
            if (entry.getValue()) {
                hasOne = true;
                break;//if one is found to be true, submit request
            } else
                hasOne = false;
        }
        if (hasOne) {//if atleast one in here, request. otherwise just drop redirect.
            LabRequestSQL.addLabRequest(request);
        }
        return "redirect:/select_patient";
    }
}
