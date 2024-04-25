package com.udea.vuelosudea.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestService {
    @GetMapping("/")
    public String healthCheck(){
        return "APPLICACION FUNCIONANDO OK";
    }
    @GetMapping("/version")
    public String version(){
        return "la version actual es 1.0.0";
    }
}
