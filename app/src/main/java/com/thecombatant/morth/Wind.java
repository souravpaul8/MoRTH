package com.thecombatant.morth;

public class Wind {

    String location;
    String date;
    int wind;
    String cause;
    String locality;

    public Wind() {

    }

    public Wind(String location, String date, int wind, String cause, String locality) {
        this.location = location;
        this.date = date;
        this.wind = wind;
        this.cause = cause;
        this.locality = locality;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public int getWind() {
        return wind;
    }

    public String getCause() {
        return cause;
    }

    public String getLocality() {
        return locality;
    }
}