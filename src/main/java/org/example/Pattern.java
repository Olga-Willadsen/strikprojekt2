package org.example;

public class Pattern {

    private boolean isNeckFolded;
    private boolean isEvenNumber;


    Pattern (boolean isNeckfolded, boolean isEvenNumber){
        this.isNeckFolded=isNeckfolded;
        this.isEvenNumber=isEvenNumber;
    }


    public boolean []  patternOptions() {
        boolean one;
        boolean two;
        boolean [] options=new boolean[2];

        String neck = TextUI.promptString("is neck folded? y/n");
        if (neck.equalsIgnoreCase("y")) {
            one = true;
        } else one = false;

        String patternRepeat = TextUI.promptString("should pattern be an even number of stitches?");
        if (patternRepeat.equalsIgnoreCase("y")) {
            two = true;
        } else two = false;

        options[0]=one;
        options[1]=two;

        return options;



    }




}


