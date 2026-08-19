package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Base64;
import java.util.List;

import static org.example.Main.gson;

public class RavelryClient {



    public HttpResponse<String> response (String endPoint, String searchTerm) {

        HttpResponse<String> response=null;
        try {
            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(endPoint+searchTerm+"&page_size=20"))
                    .header("Authorization", "Basic " + Base64.getEncoder().encodeToString("read-2e8bd4fb6dbaec93dae7ce52f94c8c8f:0dxWJVT6EIhr7wxNghbLyoPKrG4/hOjN3gyudtbj".getBytes()))
                    .GET()
                    .build();

            response = client.send(request, HttpResponse.BodyHandlers.ofString());
            //System.out.println(response.body());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return response;
    }

    public void getFirstResultFreeSearch (String searchTerm) {
        String endPoint= "https://api.ravelry.com/yarns/search.json?query=";

        HttpResponse<String> response = response(endPoint, searchTerm);

        try {
            YarnSearchResponse result = gson.fromJson(response.body(), YarnSearchResponse.class);
           // System.out.println(result.getYarns().size());
            List<Yarn> yarns = result.getYarns();
            Yarn testResult = yarns.get(0);
            System.out.println(testResult);

        }catch (NullPointerException n){
            System.out.println(n.getMessage());
        }
    }

    public void searchByGauge (double minGauge, double maxGauge){

        String endPoint = "https://api.ravelry.com/yarns/search.json?gauge-cm=";
        String searchTerm =minGauge+"%7C"+maxGauge;

        HttpResponse<String> response = response(endPoint,searchTerm);

        try {
            YarnSearchResponse result = gson.fromJson(response.body(), YarnSearchResponse.class);
            System.out.println(result.getYarns().size());
            List<Yarn> yarns = result.getYarns();
            //Yarn testResult = yarns.get(0);
            //System.out.println(testResult);

            for (int i = 0; i < 10; i++) {
                System.out.println(yarns.get(i));
                i++;
            }

        }catch (NullPointerException n){
            System.out.println(n.getMessage());
        }





    }









}
