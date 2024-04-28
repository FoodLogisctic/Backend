package com.upc.tp.entities;

import com.upc.tp.keys.PlatoInsumoKey;
import com.upc.tp.keys.VentaPlatoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class PlatoInsumo {
    @EmbeddedId
    private PlatoInsumoKey id=new PlatoInsumoKey();
    @ManyToOne
    @MapsId("platoId")
    @JoinColumn(name = "plato_id")
    private Plato plato;
    @ManyToOne()
    @MapsId("insumoId")
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
    @Column(length = 35, nullable = false)
    private long cantidad_insumo;
}
