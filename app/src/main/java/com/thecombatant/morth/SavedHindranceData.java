package com.thecombatant.morth;

public class SavedHindranceData {

    private String date;
    private String locality;
    private String cause;

    public SavedHindranceData() {

    }

    public SavedHindranceData(String date, String locality, String cause) {
        this.date = date;
        this.locality = locality;
        this.cause = cause;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }
}