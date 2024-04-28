package com.upc.tp.keys;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlatoInsumoKey implements Serializable {
    @Column(name = "plato_id")
    private Long platoId;
    @Column(name = "insumo_id")
    private Long insumoId;
}
