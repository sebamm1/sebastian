package com.example.sebastian.model;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Evento {

    private String id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombre;

    @Min(value = 1, message = "El evento debe ser al menos 1")
    private int evento;

    @NotNull(message = "La fecha no puede ser nula")
    private LocalDate fecha;

    @NotBlank(message = "La ubicación no puede estar vacía")
    private String ubicacion;

    @Min(value = 1, message = "La capacidad debe ser al menos 1")
    private int capacidad;

    @NotBlank(message = "El estado no puede estar vacio")
    private String estado;

    
}
