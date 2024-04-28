package com.udea.vuelosudea.service;

import com.udea.vuelosudea.dao.IFlightDAO;
import com.udea.vuelosudea.exception.FlightNoFoundException;
import com.udea.vuelosudea.model.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FlightService {
    @Autowired
    private IFlightDAO dao;

    public Flight save(Flight f){return dao.save(f);}
    public String delte(long id) {dao.deleteById(id); return "vuelo borrado";}
    public Iterable<Flight> list() {return dao.findAll();}
    public Optional<Flight> listId(long id) { return dao.findById(id);}
    public Flight update (Flight f){
        Flight existingFlight = dao.findById(f.getIdFlight()).orElse(null);
        existingFlight.setNombreAvion(f.getNombreAvion());
        existingFlight.setNumeroVuelo(f.getNumeroVuelo());
        existingFlight.setOrigen(f.getOrigen());
        existingFlight.setDestino(f.getDestino());
        existingFlight.setRating(f.getRating());
        existingFlight.setPlanVuelo(f.getPlanVuelo());
        existingFlight.setCapacidad(f.getCapacidad());
        existingFlight.setCumplido(f.getCumplido());
        return dao.save(existingFlight);
    }

    public List<Flight> viewBestflight() throws FlightNoFoundException {
        List<Flight> flights = dao.viewBestFlight();
        if (flights.size()>0){
            return flights;
        }
        else{
            throw new FlightNoFoundException("no se encontraron vuelos con un rating >=4");
        }
    }

}

