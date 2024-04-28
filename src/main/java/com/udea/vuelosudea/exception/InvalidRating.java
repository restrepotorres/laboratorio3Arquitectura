package com.udea.vuelosudea.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

public class InvalidRating extends RuntimeException{
    public InvalidRating(){
        super();
    }
    public InvalidRating(String mensaje){
        super(mensaje);
    }

}
