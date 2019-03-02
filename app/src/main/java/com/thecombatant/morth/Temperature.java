package com.thecombatant.morth;

public class Temperature {

    String location;
    String date;
    int temperature;
    String cause;
    String locality;

    public Temperature() {

    }

    public Temperature(String location, String date, int temperature, String cause, String locality) {
        this.location = location;
        this.date = date;
        this.temperature = temperature;
        this.cause = cause;
        this.locality = locality;
    }

    public String getLocation() {
        return location;
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
