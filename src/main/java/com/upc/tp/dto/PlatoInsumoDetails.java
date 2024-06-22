package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoInsumoDetails {
    private String namePlato;
    private String nombre;
    private long cantidad_insumo;
}
