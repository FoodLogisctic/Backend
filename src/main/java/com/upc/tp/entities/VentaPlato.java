package com.upc.tp.entities;

import com.upc.tp.keys.VentaPlatoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class VentaPlato {
    @EmbeddedId
    private VentaPlatoKey id=new VentaPlatoKey();
    @ManyToOne
    @MapsId("platoId")
    @JoinColumn(name = "plato_id")
    private Plato plato;
    @ManyToOne()
    @MapsId("ventaId")
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @Column(length = 35, nullable = false)
    private long cantidad;
    @Column(length = 35, nullable = false)
    private String observaciones;
}
