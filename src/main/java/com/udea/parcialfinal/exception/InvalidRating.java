package com.udea.parcialfinal.exception;

public class InvalidRating extends RuntimeException{
    public InvalidRating(){
        super();
    }
    public InvalidRating(String mensaje){
        super(mensaje);
    }

}
