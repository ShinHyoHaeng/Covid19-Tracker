package io.haeng.covid19tracker.models;

import java.text.DecimalFormat;

public class LocationStats {

    private String state;
    private String country;
    private int latestTotalCases;
    private int diffFromPrevDay;

    DecimalFormat formatter = new DecimalFormat("###,###");

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(int latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    public int getDiffFromPrevDay() {
        return diffFromPrevDay;
    }

    public void setDiffFromPrevDay(int diffFromPrevDay) {
        this.diffFromPrevDay = diffFromPrevDay;
    }

    public String intToString_diff(int diffFromPrevDay){
        this.diffFromPrevDay = diffFromPrevDay;
        return formatter.format(diffFromPrevDay);
    }

    public String intToString_latest(int latestTotalCases){
        this.latestTotalCases = latestTotalCases;
        return formatter.format(latestTotalCases);
    }

    @Override
    public String toString() {
        return "LocationStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", latestTotalCases=" + intToString_latest(latestTotalCases) +
                ", diffFromPrevDay=" + intToString_diff(diffFromPrevDay) +
                '}';
    }
}