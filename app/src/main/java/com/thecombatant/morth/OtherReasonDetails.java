package com.thecombatant.morth;

public class OtherReasonDetails {

    String id;
    String date;
    String cause;
    String locality;
    String imageUrl;

    public OtherReasonDetails(){

    }

    public OtherReasonDetails(String id, String date, String cause, String locality, String imageUrl) {
        this.id = id;
        this.date = date;
        this.cause = cause;
        this.locality = locality;
        this.imageUrl = imageUrl;
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

    public String getImageUrl() {
        return imageUrl;
    }
}
