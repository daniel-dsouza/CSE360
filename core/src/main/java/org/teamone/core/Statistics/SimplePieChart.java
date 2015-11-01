package org.teamone.core.Statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by daniel on 10/31/15.
 */
public class SimplePieChart extends HighChart {

    Map<String, Object> pie;
    Map<String, Object> s1;
    ArrayList<ArrayList<Object>> data;

    public SimplePieChart() {
        super();
        pie = new HashMap<String, Object>();
        pie.put("allowPointSelect", true);
        pie.put("cursor", "pointer");
        plotOptions.put("pie", pie);

        s1 = new HashMap<String, Object>();
        s1.put("type", "pie");
        s1.put("name", "browser share");


        data = new ArrayList<ArrayList<Object>>();
        s1.put("data", data);
        addData("Firefox", 50.0);
        addData("IE", 50.0);
        series.add(s1);

    }

    public void addData(String name, Double value) {
        ArrayList<Object> list = new ArrayList<Object>();
        list.add(name);
        list.add(value);
        this.data.add(list);
    }
}
