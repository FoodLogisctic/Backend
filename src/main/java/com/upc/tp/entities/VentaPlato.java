package com.upc.tp.entities;

import com.upc.tp.keys.VentaPlatoKey;
import com.upc.tp.keys.VentaPlatoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
public class VentaPlato {
    @EmbeddedId
    private VentaPlatoKey id;
    @ManyToOne
    @MapsId("platoId")
    @JoinColumn(name = "plato_id")
    private Plato plato;
    @ManyToOne
    @MapsId("ventaId")
    @JoinColumn(name = "venta_id")
    private Venta venta;
    @Column(length = 35, nullable = false)
    private long cantidad;
    @Column(length = 35, nullable = false)
    private String observaciones;

    public VentaPlato(){}
    public VentaPlato(Plato plato, Venta venta, long cantidad,String observaciones) {
        this.plato = plato;
        this.venta = venta;
        this.cantidad = cantidad;
        this.observaciones=observaciones;
        this.id = new VentaPlatoKey(plato.getId(), venta.getId());
    }

    public VentaPlatoKey getId() {
        return id;
    }

    public void setId(VentaPlatoKey id) {
        this.id = id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public long getCantidad() {
        return cantidad;
    }

    public void setCantidad(long cantidad) {
        this.cantidad = cantidad;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
}
