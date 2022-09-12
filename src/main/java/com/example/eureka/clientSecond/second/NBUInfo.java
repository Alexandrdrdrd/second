package com.example.eureka.clientSecond.second;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

@Component
public class NBUInfo {
    public JsonNode getNBUInfo() {
        JsonNode respons = null;
        try {

            String url = "https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json";
            URL obj = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) obj.openConnection();

            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();


            respons = new ObjectMapper().readTree(response.toString());


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return respons;
        }
    }
}
