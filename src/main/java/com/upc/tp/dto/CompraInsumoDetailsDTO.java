package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInsumoDetailsDTO {
    private String proveedor;
    private String nombre;
    private int cantidad;
    private double precio;
}
