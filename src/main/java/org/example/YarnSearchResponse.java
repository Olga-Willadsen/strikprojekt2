package org.example;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class YarnSearchResponse {

        @SerializedName("yarns")
        private List<Yarn> yarns;


    public List<Yarn> getYarns() {
        return yarns;
    }

}
