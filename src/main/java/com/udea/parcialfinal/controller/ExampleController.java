package com.udea.parcialfinal.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/example")
@CrossOrigin("*")
@Tag(name = "sistema de ejemplos de vuelos", description = "operaciones para los ejemplos")
public class ExampleController {


    @GetMapping(value = "/health", produces = "application/vnd.parcialfinal.v1+json")
    public String healthv1(){

        return "version 1";
    }


    @GetMapping(value = "/health",produces = "application/vnd.parcialfinal.v2+json")
    public String healthv2(){

        return "hola mundo version 2";
    }
}
