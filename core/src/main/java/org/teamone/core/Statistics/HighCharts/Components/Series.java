package org.teamone.core.Statistics.HighCharts.Components;

import java.util.ArrayList;

/**
 * Created by daniel on 10/31/15.
 */
public class Series {

    public String name;
    public Object data;

    public Series(String name, ArrayList<Object> data) {
        this.name = name;
        this.data = data;
    }

    public Series(String name, Object data) {
        this.name = name;
        this.data = data;
    }
}
