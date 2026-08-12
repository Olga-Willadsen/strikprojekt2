package org.example;

import java.util.Scanner;

public class TextUI {

    static Scanner scan = new Scanner(System.in);

    static public String promptString (String message){
        System.out.println(message);
        return scan.nextLine();
    }

    static public double promptDouble(String message){
        System.out.println(message);
        return scan.nextDouble();
    }

    static void printMessage (String message){
        System.out.println(message);
    }

}
