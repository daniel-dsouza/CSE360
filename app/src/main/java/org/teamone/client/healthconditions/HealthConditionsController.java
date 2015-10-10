package org.teamone.client.healthconditions;

import org.springframework.stereotype.Controller;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;


/**
 * Created by daniel on 10/9/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/heathconditions/{userID}")
public class HealthConditionsController {

    @RequestMapping(method = RequestMethod.GET)
    public String viewHeathConditions(
            Map<String, Object> model,
            @PathVariable String userID
    ) {
        System.out.println("view user health conditions for " + userID);
        System.out.print(model);
        return "health-conditions/edithealthconditions";
    }

    @RequestMapping(method = RequestMethod.POST)
    public void editHealthConditions(
            Map<String, Object> model
    ) {
        System.out.println("do stuff");
    }
}
