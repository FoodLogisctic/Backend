package com.upc.tp.dto;

import com.upc.tp.entities.Mesa;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaDTO {
    private Long id;
    private LocalDate fecha;
    private double monto;
    private Mesa mesa;
}
