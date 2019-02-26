package com.thecombatant.morth;

public class Wind {

    String wid;
    String wdate;
    int wind;
    String cause;

    public Wind() {

    }

    public Wind(String wid, String wdate, int wind, String cause) {
        this.wid = wid;
        this.wdate = wdate;
        this.wind = wind;
        this.cause = cause;
    }

    public String getWid() {
        return wid;
    }

    public String getWdate() {
        return wdate;
    }

    public int getWind() {
        return wind;
    }

    public String getCause() {
        return cause;
    }
}