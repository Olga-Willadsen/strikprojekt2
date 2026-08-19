package org.example;

import com.google.gson.Gson;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

public class Main {

    static Gauge gauge1;
    static MeasurementChart m1;
    static Pattern currentPattern;
    static PatternCalculator PC=new PatternCalculator();
    static Menu menu=new Menu();
    static Gson gson = new Gson();



    public static void main (String [] args){

        String URL="jdbc:sqlite:data/knitting.db";
        DBConnector dbConnector= new DBConnector(URL);
        GaugeDAO gaugeDAO= new GaugeDAO(dbConnector);
        RavelryClient RC = new RavelryClient();


//        try {
//            gaugeDAO.createTable();
//        } catch (SQLException e) {
//            System.out.println("create table stop");
//            System.out.println(e.getMessage());
//        }

        Gauge g1=new Gauge("test", 5.5, 10.0, 12.0);



RC.searchByGauge(10, 12);








        }
    }

