package org.teamone.client.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.teamone.core.SQL.PrescriptionSQL;
import org.teamone.core.prescriptions.Prescription;
import org.teamone.core.users.Patient;

import java.util.List;
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
    public void setNavbar(Map<String, Object> model) {
        java.util.Date dateAndTime = new java.util.Date();
        java.text.SimpleDateFormat sdf =
                new java.text.SimpleDateFormat("h:mm:ss a");
        String Time = sdf.format(dateAndTime);

        System.out.println("loading navbar " + Time);
        model.put("user", user);
        model.put("pageactions", new TreeMap<String, String>());
        model.put("readonly", false);
        model.put("colors", false);

        if (user.getPerson() instanceof Patient) {
            List<Prescription> list = PrescriptionSQL.getListPrescription((Patient) user.getPerson());
            for (Prescription p : list) {
                if (p.getPrescriptionType().equals("LSD")) {
                    model.put("colors", true);
                    break;
                }
            }
        }

    }
}
