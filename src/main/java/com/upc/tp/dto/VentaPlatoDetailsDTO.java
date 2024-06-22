package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaPlatoDetailsDTO {
    private String namePlato;
    private LocalDate fecha;
    private double monto;
    private long cantidad;
    private String observaciones;
}
