package com.upc.tp.entities;

import com.upc.tp.keys.CompraInsumoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompraInsumo {
    @EmbeddedId
    private CompraInsumoKey id=new CompraInsumoKey();
    @ManyToOne
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private Compra compra;
    @ManyToOne()
    @MapsId("insumoId")
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precioUnit;
}
