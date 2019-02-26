package com.thecombatant.morth;

public class weather {

    String id;
    String date;
    Double rainInMM;
    String cause;
    String locality;

    public weather() {

    }

    public weather(String id, String date, Double rainInMM, String cause, String locality) {
        this.id = id;
        this.date = date;
        this.rainInMM = rainInMM;
        this.cause = cause;
        this.locality = locality;
    }

    public String getId() {
        return id;
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