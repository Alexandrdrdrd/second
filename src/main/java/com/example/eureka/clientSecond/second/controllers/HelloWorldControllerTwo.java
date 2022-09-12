package com.example.eureka.clientSecond.second.controllers;

import com.example.eureka.clientSecond.second.NBUEntity.UAHToForeign;
import com.example.eureka.clientSecond.second.NBUInfo;
import com.example.eureka.clientSecond.second.communication.Communication;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class HelloWorldControllerTwo {
    @Autowired
    NBUInfo nbuInfo;

    @Autowired
    Communication communication;

    @GetMapping("/feign-client-nbu/exchange")
    public List<UAHToForeign> getHelloWorld()
    {
        return communication.getUAHtoForeign();
    }
}


