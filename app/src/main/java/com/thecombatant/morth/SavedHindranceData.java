package com.thecombatant.morth;

public class SavedHindranceData {

    private String date;
    private String location;
    private String reason;

    public SavedHindranceData(String date, String location, String reason) {
        this.date = date;
        this.location = location;
        this.reason = reason;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}