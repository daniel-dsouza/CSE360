package org.teamone.client.lab;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.LabTestSQL;
import org.teamone.core.labs.LabTest;
import org.teamone.core.labs.LabTestRequest;
import org.teamone.core.users.LabStaff;

import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/24/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="/**/lab_report")
public class LabTestController {

    @RequestMapping(method= RequestMethod.GET)
    public String list (Map<String, Object> model,
                        @ModelAttribute User user) {
        if (user.getPerson() == null)
            return "redirect:/login";
        else if (!(user.getPerson() instanceof LabStaff))
            return "redirect:/user/" + user.person.getUserID();
        List labReportsList = LabTestSQL.getAllLabTests();
        model.put("list", labReportsList);
        return "lab/listlabreport";
    }

    @RequestMapping(value="/{reportID}/view", method= RequestMethod.GET)
    public String viewGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute("user") User user) {
        if (user.getPerson() == null)
            return "login/login";

        return "lab/viewlabreport";
    }

    @RequestMapping(value="/{reportID}/edit", method= RequestMethod.GET)
    public String editGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute("user") User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{reportID}/edit", method= RequestMethod.POST)
    public String editPost (Map<String, Object> model,
                            @PathVariable String reportID,
                            @ModelAttribute("user") User user) {
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{reportID}/create", method= RequestMethod.GET)
    public String createGet (Map<String, Object> model,
                        @PathVariable String reportID,
                        @ModelAttribute("user") User user) {
        int id = 0;
        String testString = "";
        try {
            id = Integer.parseInt(reportID);
        } catch (Exception e) { e.printStackTrace(); }

        LabTestRequest testID = new LabTestRequest();
        testID.setRequestionID(id);
        LabTestRequest input = LabTestSQL.viewLabRequest(testID); //get the labrequest.

        LabTest newReport = new LabTest(id, ""); //only put the needed fields in the report.
        for(String test : input.getLabTestRequest().keySet()) {
            if (input.getLabTestRequest().get(test)) {
                newReport.getlabTest().put(test, "");
            }
        }
        model.put("report", newReport);
        return "lab/editlabreport";
    }

    @RequestMapping(value="/{reportID}/create", method= RequestMethod.POST)
    public String createPost (Map<String, Object> model,
                              @PathVariable String reportID,
                              @ModelAttribute("report") LabTest report,
                              @ModelAttribute("user") User user) {
        //report.setStaff()
        return "lab/editlabreport";
    }
}
