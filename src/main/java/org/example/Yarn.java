package org.example;

import com.google.gson.annotations.SerializedName;

public class Yarn {

    @SerializedName("name")
    private String yarnName;
    @SerializedName("yarn_company_name")
    private String yarnCompany;
    @SerializedName("min_gauge")
    private double yarnGauge;
    @SerializedName("yardage")
    private double yardage;
    @SerializedName("yarn_weight")
    private YarnWeightName yarnWeightName;

    //@SerializedName("min_needle_size")
    //private NeedleSize needleSize;


    Yarn (String yarnName, String yarnCompany, double yarnGauge, double yardage, YarnWeightName yarnWeightName){
        this.yarnName=yarnName;
        this.yarnCompany=yarnCompany;
        this.yarnGauge=yarnGauge;
        this.yardage=yardage;
        this.yarnWeightName=yarnWeightName;

    }

    @Override
    public String toString() {
        return "Yarn{" +
                "yarnName='" + yarnName + '\'' +
                ", yarnCompany='" + yarnCompany + '\'' +
                ", yarnGauge=" + yarnGauge +
                ", yardage=" + yardage +
                ", yarnWeight=" + yarnWeightName.getYarnWeightName() +
                '}';
    }
}
