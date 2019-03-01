package com.thecombatant.morth;

public class Wind {

    String id;
    String date;
    int wind;
    String cause;
    String locality;

    public Wind() {

    }

    public Wind(String id, String date, int wind, String cause, String locality) {
        this.id = id;
        this.date = date;
        this.wind = wind;
        this.cause = cause;
        this.locality = locality;
    }

    public String getId() {
        return id;
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