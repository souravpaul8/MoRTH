package com.thecombatant.morth;

public class Temperature {

    String id;
    String date;
    int temperature;
    String cause;
    String locality;

    public Temperature() {

    }

    public Temperature(String id, String date, int temperature, String cause, String locality) {
        this.id = id;
        this.date = date;
        this.temperature = temperature;
        this.cause = cause;
        this.locality = locality;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getCause() {
        return cause;
    }

    public String getLocality() {
        return locality;
    }
}
