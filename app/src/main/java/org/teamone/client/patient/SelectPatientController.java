package org.teamone.client.patient;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.teamone.core.SQL.PatientSQL;
import org.teamone.core.users.Patient;

import java.util.ArrayList;
import java.util.Map;

/**
 * Created by daniel on 10/28/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="selectpatient")
public class SelectPatientController {

    @RequestMapping(method=RequestMethod.GET)
    public String renderOptions(Map<String, Object> model) {
        ArrayList<Patient> patients = PatientSQL.getAllPatient();
        model.put("patients", patients);
        return "patient/selectpatient";
    }

    @RequestMapping(method= RequestMethod.POST)
    public String goToOption() {
        return "";
    }
}
