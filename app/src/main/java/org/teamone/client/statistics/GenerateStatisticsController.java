package org.teamone.client.statistics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teamone.core.Statistics.HighCharts.BasicColumnChart;
import org.teamone.core.Statistics.HighCharts.BasicPieChart;
import org.teamone.core.Statistics.HighCharts.HighChart;

import java.util.*;

/**
 * Created by daniel on 10/31/15.
 */

@Controller
@Scope("request")
@RequestMapping(value="/stats")
public class GenerateStatisticsController {

    @RequestMapping(value="/patients_per_specialty", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    BasicPieChart getPatientsPerSpecialty () {
        BasicPieChart chart = new BasicPieChart();
        chart.setTitleHTML("nom");
        Map<String, Double> mip = new HashMap<String, Double>();
        mip.put("Firefox", 50.0);
        mip.put("IE", 50.0);
        chart.addData("b-data", mip);
        return chart;
    }

    @RequestMapping(value="/number_of_alerts", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    BasicColumnChart getNumberOfAlerts () {
        BasicColumnChart chart = new BasicColumnChart();
        chart.setTitleHTML("nom2");
        List<String> months = Arrays.asList("Jan","Feb","Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Rainfall (mm)");
        chart.addData("Tokyo", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        return chart;
    }

    @RequestMapping(value="/new_patients", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getNewPatients () {
        BasicPieChart chart = new BasicPieChart();
        return chart;
    }

    @RequestMapping(value="/age_groups", method = RequestMethod. GET,produces="application/json")
    public @ResponseBody
    HighChart getAgeGroups () {
        BasicPieChart chart = new BasicPieChart();
        return chart;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String dispStats(Map<String, Object> model) {
        return "statistics/stats";
    }
}
