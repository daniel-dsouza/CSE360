package org.teamone.core.Statistics.HighCharts;

import org.teamone.core.Statistics.HighCharts.Components.Title;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */
public class HighChart {
    public Map<String, Object> chart, subtitle, tooltip, plotOptions, credits, xAxis, yAxis;
    public Title title;
    public ArrayList<Object> series;

    public HighChart() {
        chart = new HashMap<String, Object>();
        chart.put("plotBackgroundColor", null);
        chart.put("plotBorderWidth", null);
        chart.put("plotShadow", false);

        title = new Title();

        subtitle = new HashMap<String, Object>();
        subtitle.put("text", "");

        tooltip = new HashMap<String, Object>();

        plotOptions = new HashMap<String, Object>();

        credits = new HashMap<String, Object>();
        credits.put("enabled", false);

        series = new ArrayList<Object>();
    }

    public void setTitleHTML(String html) {
        this.title.text = html;
    }

    public void setSubTitleHTML(String html) {
        this.subtitle.put("text", html);
    }
}
