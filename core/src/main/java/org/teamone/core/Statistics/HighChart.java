package org.teamone.core.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */
public abstract class HighChart {
    public Map<String, Object> chart;
    public Map<String, Object> title;
    public Map<String, Object> tooltip;
    public Map<String, Object> plotOptions;
    public ArrayList<Object> series;

    public HighChart() {
        chart = new HashMap<String, Object>();
        chart.put("plotBackgroundColor", null);
        chart.put("plotBorderWidth", null);
        chart.put("plotShadow", false);

        title = new HashMap<String, Object>();
        title.put("text", "Browser<br>shares");
        title.put("align", "center");
        title.put("verticalAlign", "middle");
        //title.put("y", 50);

        tooltip = new HashMap<String, Object>();
        tooltip.put("pointFormat", "{series.name}: <b>{point.percentage:.1f}%</b>");

        plotOptions = new HashMap<String, Object>();

        series = new ArrayList<Object>();
    }

    public void setTitleHTML(String html) {
        this.title.put("text", html);
    }
}
