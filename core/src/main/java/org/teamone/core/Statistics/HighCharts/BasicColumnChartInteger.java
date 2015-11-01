package org.teamone.core.Statistics.HighCharts;

import org.teamone.core.Statistics.HighCharts.Components.Series;
import org.teamone.core.Statistics.HighCharts.Components.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */
public class BasicColumnChartInteger extends HighChart{

    Map<String, Object> column;

    /**
     * Creates a simple column chart
     * http://www.tutorialspoint.com/highcharts/highcharts_column_basic.htm
     */
    public BasicColumnChartInteger() {
        super();
        chart.put("type", "column");

        xAxis = new HashMap<String, Object>();
        xAxis.put("categories", new ArrayList<Object>());
        xAxis.put("crosshair", true);
        xAxis.put("title", new Title());

        yAxis = new HashMap<String, Object>();
        yAxis.put("min", 0);
        yAxis.put("title", new Title());

        tooltip.put("headerFormat", "<span style=\"font-size:10px\">{point.key}</span><table>");
        tooltip.put("pointFormat", "<tr><td style=\"color:{series.color};padding:0\">{series.name}: </td>" +
                "<td style=\"padding:0\"><b>{point.y:.1f} mm</b></td></tr>");
        tooltip.put("footerFormat", "</table>");
        tooltip.put("shared", true);
        tooltip.put("useHTML", true);

        column = new HashMap<String, Object>();
        column.put("pointPadding", 0.2);
        column.put("borderWidth", 0);
        plotOptions.put("column", column);
    }

    public void addXAxis(String title, List<String> xaxis) {
        this.xAxis.put("title", new Title(title));
        this.xAxis.put("categories", xaxis);
    }

    public void addYAxis(String title) {
        this.yAxis.put("title", new Title(title));
    }

    /**
     * Adds data to a simple column chart.
     * @param name the key for the value
     * @param value the arraylist of values.
     */
    public void addData(String name, ArrayList<Integer> value) {
        this.series.add(new Series(name, value));
    }
}
