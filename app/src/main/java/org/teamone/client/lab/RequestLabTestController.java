package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.DoctorSQL;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.Doctor;
import org.teamone.core.users.LabStaff;
import org.teamone.core.users.Patient;
import org.teamone.core.users.Person;

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
        List labRequestList = LabTestSQL.getAllLabRequests();
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
        if(!(user.getPerson() instanceof LabStaff) && !(user.getPerson() instanceof Doctor))
            return "redirect:/user/" + user.person.getUserID();

        LabTestRequest testID = new LabTestRequest();
        try {
            testID.setRequestionID(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: redirect to error page.
        }

        LabTestRequest request = LabTestSQL.viewLabRequest(testID);
        model.put("request", request);

        if (request == null) {
            System.out.println(Integer.parseInt(id) +" this returns null");
            return "lab/editlabtestrequest";
        }

        for(String key : request.getLabTestRequest().keySet()) {
            if (request.getLabTestRequest().get(key))
                System.out.println(key + " ");
        }

        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String getList(Map<String, Object> model,
                          @ModelAttribute User user) {
        if(user.getPerson() == null)
            return "redirect:/login";


        if (user.getPerson() == null)
            System.err.println("Person is null");
        else
            System.err.println("Person is ok");

        LabTestRequest request = new LabTestRequest();
        model.put("request", request);
        return "lab/editlabtestrequest";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String submitTest (Map<String, Object> model,
                              @ModelAttribute("request") LabTestRequest request) {
        for(String key : request.getLabTestRequest().keySet()) {
            if (request.getLabTestRequest().get(key))
                System.out.println(key + " ");
        }

        request.setRequestionID(0);
        Patient test = new Patient();
        test.setPatientID(1005);
        request.setPatient(test);
        Person per = new Person();
        per.setUserID(506);
        request.setPerson(per);

        DoctorSQL.addLabRequest(request);
        return "auth/user"; //TODO: send back to Select Patient.
    }
}
