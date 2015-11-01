package org.teamone.client.statistics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teamone.core.Statistics.HighChart;
import org.teamone.core.Statistics.SimplePieChart;

import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="/stats")
public class GenerateStatisticsController {

    @RequestMapping(value="/s", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getchart () {
        HighChart chart = new SimplePieChart();
        return chart;
    }

    @RequestMapping(value="/patients_per_specialty", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getPatientsPerSpecialty () {
        HighChart chart = new SimplePieChart();
        return chart;
    }

    @RequestMapping(value="/number_of_alerts", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getNumberOfAlerts () {
        HighChart chart = new SimplePieChart();
        return chart;
    }

    @RequestMapping(value="/new_patients", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getNewPatients () {
        HighChart chart = new SimplePieChart();
        return chart;
    }

    @RequestMapping(value="/age_groups", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getAgeGroups () {
        HighChart chart = new SimplePieChart();
        return chart;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String dispStats(Map<String, Object> model) {
        return "statistics/stats";
    }
}
