package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.Base64;

public class Main {

    static Gauge gauge1;
    static MeasurementChart m1;
    static Pattern currentPattern;
    static PatternCalculator PC=new PatternCalculator();
    static Menu menu=new Menu();



    public static void main (String [] args){

        String URL="jdbc:sqlite:data/knitting.db";
        DBConnector dbConnector= new DBConnector(URL);
        GaugeDAO gaugeDAO= new GaugeDAO(dbConnector);

//        try {
//            gaugeDAO.createTable();
//        } catch (SQLException e) {
//            System.out.println("create table stop");
//            System.out.println(e.getMessage());
//        }

        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.ravelry.com/yarns/search.json?query=drops+snow"))
                    .header("Authorization", "Basic " + Base64.getEncoder().encodeToString("read-2e8bd4fb6dbaec93dae7ce52f94c8c8f:0dxWJVT6EIhr7wxNghbLyoPKrG4/hOjN3gyudtbj".getBytes()))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        }







//
//
//switch(menu.firstMenu()){
//    case "1":
//
//        break;
//    case "2":
//        break;
//    case "3":
//        break;
//}
//
//
//
//
//      PC.calculatePattern(m1, gauge1);


    }

