package com.thecombatant.morth;

public class weather {

    String location;
    String date;
    Double rainInMM;
    String cause;
    String locality;

    public weather() {

    }

    public weather(String location, String date, Double rainInMM, String cause, String locality) {
        this.location = location;
        this.date = date;
        this.rainInMM = rainInMM;
        this.cause = cause;
        this.locality = locality;
    }

    public String getLocation() {
        return location;
    }

    public String getDate() {
        return date;
    }

    public Double getRainInMM() {
        return rainInMM;
    }

    public String getCause() {
        return cause;
    }

    public String getLocality() {
        return locality;
    }
}