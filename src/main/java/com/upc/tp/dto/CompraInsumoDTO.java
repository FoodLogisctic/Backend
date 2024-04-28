package com.upc.tp.dto;

import com.upc.tp.entities.Compra;
import com.upc.tp.keys.CompraInsumoKey;
import com.upc.tp.entities.Insumo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompraInsumoDTO {
    private CompraInsumoKey id;
    private Compra compra;
    private Insumo insumo;
    private int cantidad;
    private double precioUnit;
}
