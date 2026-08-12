package org.example;

public class Gauge {

    private int id;
    private String yarnName;
    private double needleSize;

    private double stitches;
    private double rows;


    public Gauge (String yarn, double needleSize){
       this.yarnName =yarn;
       this.needleSize=needleSize;
    }

    public Gauge (int id, String yarn, double needleSize, double stitches, double rows){
        this.id=id;
        this.yarnName =yarn;
        this.needleSize=needleSize;
        this.stitches=stitches;
        this.rows=rows;
    }

    public Gauge (String yarn, double needleSize, double stitches, double rows){
        this.yarnName =yarn;
        this.needleSize=needleSize;
        this.stitches=stitches;
        this.rows=rows;
    }

    public int getId() {return id;}

    public String getYarnName() {
        return yarnName;
    }

    public void setYarnName(String yarnName) {
        this.yarnName = yarnName;
    }

    public double getNeedleSize() {
        return needleSize;
    }

    public void setNeedleSize(double needleSize) {
        this.needleSize = needleSize;
    }

    public double getStitches() {
        return stitches;
    }

    public void setStitches(double stitches) {
        this.stitches = stitches;
    }

    public double getRows() {
        return rows;
    }

    public void setRows(double rows) {
        this.rows = rows;
    }

    public double getStitchGauge() {
        return stitches/10;
    }


    public double getRowGauge() {
        return rows/10;
    }

    @Override
    public String toString() {
        return "Gauge{" +
                "yarnName='" + yarnName + '\'' +
                ", needleSize=" + needleSize +
                ", stitches=" + stitches +
                ", rows=" + rows +
                '}';
    }
}

