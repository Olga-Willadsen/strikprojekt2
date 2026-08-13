package org.example;

import com.google.gson.annotations.SerializedName;

public class NeedleSize {
    @SerializedName("metric")
    private double needleSize;

    public double getNeedleSize() {
        return needleSize;
    }
}

//virker ikke fordi dataen kun hentes når der søge på yarn ID
