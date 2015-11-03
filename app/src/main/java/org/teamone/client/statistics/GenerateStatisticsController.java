package org.teamone.client.statistics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teamone.client.generic.User;
import org.teamone.core.SQL.GenerateStatsSQL;
import org.teamone.core.Statistics.HighCharts.BasicColumnChartInteger;
import org.teamone.core.Statistics.HighCharts.BasicPieChart;
import org.teamone.core.Statistics.HighCharts.HighChart;
import org.teamone.core.users.HSP;

import java.util.*;

/**
 * Created by daniel on 10/31/15.
 */

@Controller
@Scope("request")
@RequestMapping(value = "/stats")
public class GenerateStatisticsController {

    @RequestMapping(value = "/patients_per_specialty", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    BasicColumnChartInteger getPatientsPerSpecialty() {
        BasicColumnChartInteger chart = new BasicColumnChartInteger();
        chart.setTitleHTML("Patients per Doctor Specialty");
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Doctor Type)");
        ArrayList<ArrayList<Integer>> year = GenerateStatsSQL.getNumOfPatientType();
        chart.addData("Pediatric", year.get(0));
        chart.addData("General Care", year.get(1));
        chart.addData("Radiology (X-ray)",year.get(2));
        chart.addData("Emergency",year.get(3));
        chart.addData("Neurology", year.get(4));
        return chart;
    }

    @RequestMapping(value = "/number_of_alerts", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    BasicColumnChartInteger getNumberOfAlerts() {
        BasicColumnChartInteger chart = new BasicColumnChartInteger();
        chart.setTitleHTML("Number of Alerts");
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Number of Alert");
        chart.addData("Alerts", GenerateStatsSQL.getNumOfAlerts());
        return chart;
    }

    @RequestMapping(value = "/new_patients", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    BasicColumnChartInteger getNewPatients() {
        BasicColumnChartInteger chart = new BasicColumnChartInteger();
        chart.setTitleHTML("Number of New Patients");
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Number of Patients Registered");
        chart.addData("Patients", GenerateStatsSQL.getNumOfNewPatients());
        return chart;
    }

    @RequestMapping(value = "/female_male_ratio", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    HighChart getRatio() {
        BasicPieChart chart = new BasicPieChart();
        double m = GenerateStatsSQL.getMalePopulation();
        double f = GenerateStatsSQL.getFemalePopulation();
        Double male = new Double(m);
        Double female = new Double(f);
        Map<String, Double> gender = new HashMap<String, Double>();
        gender.put("Female", female);
        gender.put("Male", male);
        chart.addData("Gender",gender);
        return chart;
    }

    @RequestMapping(value = "/age_groups", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    HighChart getAgeGroups() {
        BasicPieChart chart = new BasicPieChart();
        double age[] = GenerateStatsSQL.getAgePopulation();
        Double group1 = new Double(age[0]);
        Double group2 = new Double(age[1]);
        Double group3 = new Double(age[2]);
        Double group4 = new Double(age[3]);
        Double group5 = new Double(age[4]);
        Double group6 = new Double(age[5]);
        Double group7 = new Double(age[6]);
        Double group8 = new Double(age[7]);
        Map<String, Double> ageGroups = new HashMap<String, Double>();
        ageGroups.put("0-12", group1);
        ageGroups.put("13-18", group2);
        ageGroups.put("19-26", group3);
        ageGroups.put("27-40", group4);
        ageGroups.put("41-50", group5);
        ageGroups.put("51-60", group6);
        ageGroups.put("61-74", group7);
        ageGroups.put("75 & Up", group8);
        chart.addData("Age",ageGroups);
        return chart;
    }


    @RequestMapping(method = RequestMethod.GET)
    public String dispStats(Map<String, Object> model,
                            @ModelAttribute User user) {

        if (user.getPerson() == null )
            return "redirect:/login";
        else if (!(user.getPerson() instanceof HSP))//only HSP
            return "redirect:/user/" + user.person.getUserID();return "statistics/stats";
    }
}
