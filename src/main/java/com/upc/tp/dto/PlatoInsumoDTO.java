package com.upc.tp.dto;

import com.upc.tp.entities.Insumo;
import com.upc.tp.entities.Plato;
import com.upc.tp.keys.PlatoInsumoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlatoInsumoDTO {
    private PlatoInsumoKey id;
    private Plato plato;
    private Insumo insumo;
    private long cantidad_insumo;
    private char observaciones;
}
