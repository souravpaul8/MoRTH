package com.thecombatant.morth;

public class OtherReasonDetails {

    String location;
    String date;
    String cause;
    String locality;
    String imageUrl;

    public OtherReasonDetails(){

    }

    public OtherReasonDetails(String location, String date, String cause, String locality, String imageUrl) {
        this.location = location;
        this.date = date;
        this.cause = cause;
        this.locality = locality;
        this.imageUrl = imageUrl;
    }


    public String getLocation() {
        return location;
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

    public String getImageUrl() {
        return imageUrl;
    }
}
