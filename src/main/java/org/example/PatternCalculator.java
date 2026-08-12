package org.example;

public class PatternCalculator {

   //alle de oprindeligt beregnede mål, skal aldrig ændres.
    private double calcBodyWidthStitches;
    private double calcTotalHeightRows;

    private double calcRaglanWidthStitches;
    private double calcNeckWidthStitches;
    private double calcArmholeBindOffStitches;

    private double calcSideseamRows;
    private double calcRaglanHeightRows;


   // modificerede mål
    private double raglanWidthStitches;
    private double neckWidthStitches;
    private double armholeBindOffStitches;
    private double bodyWidthStitches;

    private double sideseamRows;
    private double raglanHeightRows;
    private double totalHeightRows;

    private double decreases;






    private double calculateStitches(double measurement, Gauge g){
        double stitches= measurement*g.getStitchGauge();
        return Math.round(stitches);
    }

    private double calculateRows (double measurement, Gauge g){
        double rows= measurement*g.getRowGauge();
        return Math.round(rows);
    }


    public void calculatePattern(MeasurementChart m, Gauge gauge){

       calculateAllStitches(m, gauge);
       calculateAllRows(m, gauge);


       calculateRaglanDecrease();
       printOriginalCalculations();
       printModifiedMeasurements();


    }


    private void calculateAllStitches(MeasurementChart m, Gauge gauge){

        calcBodyWidthStitches=calculateStitches(m.getBodyWidthCM(), gauge);


        calcRaglanWidthStitches=calculateStitches(m.getRaglanWidthCM(), gauge);

        if (calcRaglanWidthStitches%2!=0){
            raglanWidthStitches=calcRaglanWidthStitches-1;
        } else raglanWidthStitches=calcRaglanWidthStitches;


        calcNeckWidthStitches=calculateStitches(m.getNeckWidthCM(), gauge);
        if(calcNeckWidthStitches%2!=0){
            neckWidthStitches=calcNeckWidthStitches-1;
        }else neckWidthStitches=calcNeckWidthStitches;

        calcArmholeBindOffStitches= calculateStitches(m.getArmholeBindOffCM(), gauge);
        if(calcArmholeBindOffStitches%2!=0){
            armholeBindOffStitches=calcArmholeBindOffStitches-1;
        } else armholeBindOffStitches=calcArmholeBindOffStitches;


        bodyWidthStitches=(2*raglanWidthStitches)+(2*armholeBindOffStitches)+neckWidthStitches;

    }

    private void calculateAllRows(MeasurementChart m, Gauge gauge){

        calcTotalHeightRows = calculateRows((m.getRaglanHeightCM()+m.getSideseamCM()),gauge);

        calcSideseamRows= calculateRows(m.getSideseamCM(), gauge);
        if (calcSideseamRows%2!=0){
            sideseamRows=calcSideseamRows-1;
        }else sideseamRows=calcSideseamRows;


        calcRaglanHeightRows=calculateRows(m.getRaglanHeightCM(), gauge);
        if (calcRaglanHeightRows%2!=0){
            raglanHeightRows=calcRaglanHeightRows-1;
        }else raglanHeightRows=calcRaglanHeightRows;

        totalHeightRows=raglanHeightRows+sideseamRows;

    }

    private void calculateRaglanDecrease (){

        double ratio = raglanHeightRows/raglanWidthStitches;
        //TextUI.printMessage(ratio+" initial ratio");

        double modifiedRatio = Math.round(ratio);
        if(modifiedRatio%2!=0){
            modifiedRatio--;
        }
        double aRaglanHeight = (modifiedRatio*raglanWidthStitches);
        double heightDifference = raglanHeightRows-aRaglanHeight;
        double bRaglanWidth = raglanHeightRows/modifiedRatio;
        double widthDifference= raglanWidthStitches-bRaglanWidth;


                //option A tager udgangspunkt i width measurement, option B tager udgangspunkt i height measurement.

        String version = TextUI.promptString("You have the following options for your raglan decreases:" +'\n'+
                        " A. 1 decrease every "+ modifiedRatio+" rows, "+'\n'+
                        raglanWidthStitches+ " decreases"+'\n'+
                        " raglan height: "+aRaglanHeight+ " rows"+ '\n'+
                        " raglan width: "+ raglanWidthStitches+'\n'+
                        '\n'+

                " B. 1. decrease every "+modifiedRatio+" rows, "+'\n'+
                        bRaglanWidth+" decreases"+'\n'+
                        " Raglan height: "+ raglanHeightRows+'\n'+
                        " raglan width:"+bRaglanWidth+'\n'+
                        '\n'+
                        " Whatever option chosen the difference in stitches and rows " +'\n' +
                        "will be added to either sideseam height, or neck width"

                );
        switch(version){
        case "A":
                System.out.println("A");
                decreases=raglanWidthStitches;
                raglanHeightRows=modifiedRatio*raglanWidthStitches;
                sideseamRows=sideseamRows+heightDifference;
        break;
        case "B":
                System.out.println("B");
                decreases=raglanHeightRows/modifiedRatio;
                raglanWidthStitches=raglanHeightRows/modifiedRatio;
                neckWidthStitches=neckWidthStitches+widthDifference;
        break;



        }


    }

    private void printOriginalCalculations(){


        TextUI.printMessage("Originally calculated measurements:");
        TextUI.printMessage(calcRaglanWidthStitches+" raglan width");
        TextUI.printMessage(calcNeckWidthStitches+" neck width");
        TextUI.printMessage(calcArmholeBindOffStitches+" arm hole BO");
        TextUI.printMessage(calcBodyWidthStitches+" calculated body width");

        TextUI.printMessage(calcSideseamRows+" sideseam rows");
        TextUI.printMessage(calcRaglanHeightRows+" raglan height rows");
        TextUI.printMessage(calcTotalHeightRows +" calculated total height");
        TextUI.printMessage("------------------------");


    }

    private void printModifiedMeasurements(){


        TextUI.printMessage("modified measurements:");
        TextUI.printMessage(raglanWidthStitches+" raglan width");
        TextUI.printMessage(neckWidthStitches+" neck width");
        TextUI.printMessage(armholeBindOffStitches+" arm hole BO");
        TextUI.printMessage(bodyWidthStitches+" calculated body width");

        TextUI.printMessage(sideseamRows+" sideseam rows");
        TextUI.printMessage(raglanHeightRows+" raglan height rows");
        TextUI.printMessage(totalHeightRows+" calculated total height");
        TextUI.printMessage("------------------------");


    }






}
