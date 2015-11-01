package org.teamone.client.statistics;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.teamone.core.SQL.GenerateStatsSQL;
import org.teamone.core.Statistics.HighCharts.BasicColumnChart;
import org.teamone.core.Statistics.HighCharts.BasicColumnChartInteger;
import org.teamone.core.Statistics.HighCharts.BasicPieChart;
import org.teamone.core.Statistics.HighCharts.HighChart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
    BasicColumnChart getPatientsPerSpecialty() {
        BasicColumnChart chart = new BasicColumnChart();
        chart.setTitleHTML("nom2");
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Doctor Type)");
        chart.addData("Pediatric", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("General Care", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("Emergency", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("Radiology (X-ray)", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("Neurology", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
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
    HighChart getNewPatients() {
        BasicPieChart chart = new BasicPieChart();
        return chart;
    }

    @RequestMapping(value = "/age_groups", method = RequestMethod.GET, produces = "application/json")
    public
    @ResponseBody
    HighChart getAgeGroups() {
        BasicColumnChart chart = new BasicColumnChart();
        chart.setTitleHTML("nom2");
        List<String> months = Arrays.asList("Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec");
        chart.addXAxis("Months", months);
        chart.addYAxis("Age groups");
        chart.addData("0-12", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("13-18", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("19-26", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("27-40", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("41-50", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("51-60", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("61-74", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        chart.addData("75 & Up", new ArrayList<Double>(Arrays.asList(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5, 216.4, 194.1, 95.6, 54.4)));
        return chart;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String dispStats(Map<String, Object> model) {
        return "statistics/stats";
    }
}
