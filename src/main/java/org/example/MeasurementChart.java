package org.example;

public class MeasurementChart {
    private int id;
    private String name;

    private double bodyWidthCM;
    private double sideseamCM;
    private double raglanHeightCM;
    private double raglanWidthCM;
    private double neckWidthCM;
    private double armholeBindOffCM;




    MeasurementChart(String name, double bodyWidthCM,
                     double sideseamCM, double raglanHeightCM,
                     double raglanWidthCM, double neckWidthCM, double armholeBindOffCM){
        this.name=name;
        this.bodyWidthCM=bodyWidthCM;
        this.sideseamCM=sideseamCM;
        this.raglanHeightCM=raglanHeightCM;
        this.raglanWidthCM=raglanWidthCM;
        this.neckWidthCM=neckWidthCM;
        this.armholeBindOffCM=armholeBindOffCM;
    }

    MeasurementChart(int id, String name, double bodyWidthCM,
                     double sideseamCM, double raglanHeightCM,
                     double raglanWidthCM, double neckWidthCM, double armholeBindOffCM){
        this.id=id;
        this.name=name;
        this.bodyWidthCM=bodyWidthCM;
        this.sideseamCM=sideseamCM;
        this.raglanHeightCM=raglanHeightCM;
        this.raglanWidthCM=raglanWidthCM;
        this.neckWidthCM=neckWidthCM;
        this.armholeBindOffCM=armholeBindOffCM;
    }

    public String getName() {
        return name;
    }

    public double getBodyWidthCM() {
        return bodyWidthCM;
    }

    public double getSideseamCM() {
        return sideseamCM;
    }

    public double getRaglanHeightCM() {
        return raglanHeightCM;
    }

    public double getRaglanWidthCM() {
        return raglanWidthCM;
    }

    public double getNeckWidthCM() {
        return neckWidthCM;
    }

    public double getArmholeBindOffCM() {
        return armholeBindOffCM;
    }

}
