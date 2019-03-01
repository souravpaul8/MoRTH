package com.thecombatant.morth;

public class OtherReasonDetails {

    String id;
    String date;
    String cause;
    String locality;

    public OtherReasonDetails(){

    }

    public OtherReasonDetails(String id, String date, String cause, String locality) {
        this.id = id;
        this.date = date;
        this.cause = cause;
        this.locality = locality;
    }

    public String getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getCause() {
        return cause;
    }

    public String getLocality() {
        return locality;
    }
}
