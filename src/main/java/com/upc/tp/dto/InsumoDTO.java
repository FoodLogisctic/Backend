package com.upc.tp.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoDTO {
    private Long id;
    private String nombre;
    private int cantidad;
    private String tipo;
    private char perecible;
    private LocalDate fechaVencimiento;
}
