package com.udea.parcialfinal.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Schema(description = "Todos los detalles del vuelo")
@Entity
public class Flight implements Serializable {
    @Schema
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idFlight")
    private Long idFlight;

    @Schema
    @Column(name = "nombreAvion",nullable = false,length = 80)
    private @NonNull String nombreAvion;

    @Schema
    @Column(name = "numeroVuelo",nullable = false,length = 80)
    private @NonNull String numeroVuelo;

    @Schema
    @Column(name = "origen",nullable = false,length = 80)
    private @NonNull  String origen;

    @Schema
    @Column(name = "destino",nullable = false,length = 80)
    private @NonNull  String destino;

    @Schema
    @Column(name = "capacidad",nullable = false,length = 20)
    private @NonNull  int capacidad;

    @Schema
    @Column(name = "rating",nullable = false,length = 80)
    @Min(value = 1, message = "el valor debe ser mayor o igual a 1")
    @Max(value = 5, message = "el valor debe ser menor o igual a 1")
    private @NonNull  int rating;

    @Schema
    @Column(name = "planvuelo",nullable = false,length = 80)
    private @NonNull  long planVuelo;

    @Schema
    private @NonNull  Boolean cumplido;
}
