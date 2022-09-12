package com.example.eureka.clientSecond.second.communication;

import com.example.eureka.clientSecond.second.NBUEntity.UAHToForeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class Communication {
    @Autowired
    private RestTemplate restTemplate;


    public List<UAHToForeign> getUAHtoForeign() {
        ResponseEntity<List<UAHToForeign>> responseEntity =
                restTemplate.exchange("https://bank.gov.ua/NBUStatService/v1/statdirectory/exchange?json",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<UAHToForeign>>() {
                        });
        return responseEntity.getBody();
    }
}
