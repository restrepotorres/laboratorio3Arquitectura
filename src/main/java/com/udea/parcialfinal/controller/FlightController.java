package com.udea.parcialfinal.controller;

import com.udea.parcialfinal.exception.InvalidRating;
import com.udea.parcialfinal.exception.ModelNotFoundException;
import com.udea.parcialfinal.model.Flight;
import com.udea.parcialfinal.service.FlightService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/flight")
@CrossOrigin("*")
@Tag(name = "sistema de gestion de vuelos", description = "operaciones para los vuelos")
public class FlightController {
    @Autowired
    FlightService flightService;

    @Operation(summary  = "Add vuelo", description = "Customer must exist")
    @PostMapping("/save")
    public long save(
        @Parameter(description  = "objeto vuelo que se guarda en la base de datos", required = true)
        @RequestBody Flight flight) throws InvalidRating {
        if(flight.getRating()>5)throw new InvalidRating("id debe ser menor o igual a 5");

        flightService.save(flight);
        return flight.getIdFlight();
    }

    @Operation(summary  = "ver la lista de vuelos disponibles", description = "Customer must exist")
    @ApiResponses(value = {
            @ApiResponse(responseCode  = "200", description= "lista devuelos exitosos"),
            @ApiResponse(responseCode  = "401", description = "no autorizado para ver el recurso"),
            @ApiResponse(responseCode  = "403", description = "el acceso al recurso que usted intenta alcanzar es prohibido"),
            @ApiResponse(responseCode  = "404", description = "el acceso al recurso que usted intenta alcanzar no se encuentra")
    })
    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights(){
        return flightService.list();
    }

    @Operation(description  = "obtener el vuelo por un id")
    @GetMapping("/list/{id}")
    public Flight listFlightById(
            @Parameter(description  = "el id del vuelo que se desea consultar", required = true)
            @PathVariable("id")int id){
        Optional<Flight> flight = flightService.listId(id);
        if(flight.isPresent()){
            return flight.get();
        }
        throw new ModelNotFoundException("id de vuelo Invalido");
    }
    @Operation(summary = "damel os mejores vuelos", description = "Customer must exist")
    @GetMapping("/topFlights")
    public ResponseEntity<List<Flight>> viewBestFlights(){
        List <Flight> list = flightService.viewBestflight();
        return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
    }


    @PutMapping
    public Flight updateFlight(@RequestBody Flight flight){
        return flightService.update(flight);
    }

    @DeleteMapping("{id}")
    public String deleteflight (@PathVariable long id){
        return flightService.delte(id);
    }
}
