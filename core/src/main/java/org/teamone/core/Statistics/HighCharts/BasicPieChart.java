package org.teamone.core.Statistics.HighCharts;

import org.teamone.core.Statistics.HighCharts.Components.Series;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */
public class BasicPieChart extends HighChart {

    Map<String, Object> pie;

    /**
     * Creates a simple pie chart
     */
    public BasicPieChart() {
        super();
        chart.put("type", "pie");

        tooltip.put("pointFormat", "{series.name}: <b>{point.percentage:.1f}%</b>");

        pie = new HashMap<String, Object>();
        pie.put("allowPointSelect", true);
        pie.put("cursor", "pointer");
        plotOptions.put("pie", pie);
    }

    /**
     * Adds data to the simple pie chart.
     * @param input
     */
    public void addData(String name, Map<String,Double> input) {
        ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();
        for (String key : input.keySet()) {
            ArrayList<Object> list = new ArrayList<Object>();
            list.add(key);
            list.add(input.get(key));
            data.add(list);
        }
        Series s = new Series(name, data);
        this.series.add(s);
    }
}
