package com.upc.tp.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class CompraInsumoKey implements Serializable {
    @Column(name = "compra_id")
    private Long compraId;
    @Column(name = "insumo_id")
    private Long insumoId;
}