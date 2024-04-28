package com.upc.tp.dto;

import com.upc.tp.entities.Plato;
import com.upc.tp.entities.Venta;
import com.upc.tp.keys.VentaPlatoKey;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VentaPlatoDTO {
    private VentaPlatoKey id;
    private Plato plato;
    private Venta venta;
    private long cantidad;
    private String observaciones;
}
