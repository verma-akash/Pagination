
package com.gravity.nobroker.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Score {

    @SerializedName("lastUpdatedDate")
    @Expose
    private String lastUpdatedDate;
    @SerializedName("transit")
    @Expose
    private Double transit;
    @SerializedName("lifestyle")
    @Expose
    private Double lifestyle;

    public String getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(String lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public Double getTransit() {
        return transit;
    }

    public void setTransit(Double transit) {
        this.transit = transit;
    }

    public Double getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(Double lifestyle) {
        this.lifestyle = lifestyle;
    }

}
