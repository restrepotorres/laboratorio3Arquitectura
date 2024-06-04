package com.udea.parcialfinal.controller;

import com.udea.parcialfinal.model.Flight;
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


    @GetMapping("/health")
    public String health(){

        return "hola mundo";
    }
}
