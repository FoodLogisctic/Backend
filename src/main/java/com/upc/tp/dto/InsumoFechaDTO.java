package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoFechaDTO {
    private String nombreInsumo;
    private LocalDate fechaCompra;
    private String nombreProveedor;
    private int cantidadCompra;
    private String tipoInsumo;
}
