package com.upc.tp.entities;

import com.upc.tp.keys.CompraInsumoKey;
import com.upc.tp.keys.PlatoInsumoKey;
import com.upc.tp.keys.VentaPlatoKey;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class PlatoInsumo {
    @EmbeddedId
    private PlatoInsumoKey id;
    @ManyToOne
    @MapsId("platoId")
    @JoinColumn(name = "plato_id")
    private Plato plato;
    @ManyToOne
    @MapsId("insumoId")
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
    @Column(length = 35, nullable = false)
    private long cantidad_insumo;
    public PlatoInsumo(){}
    public PlatoInsumo(Plato plato, Insumo insumo, int cantidad_insumo) {
        this.plato = plato;
        this.insumo = insumo;
        this.cantidad_insumo = cantidad_insumo;
        this.id = new PlatoInsumoKey(plato.getId(), insumo.getId());
    }

    public PlatoInsumoKey getId() {
        return id;
    }

    public void setId(PlatoInsumoKey id) {
        this.id = id;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public long getCantidad_insumo() {
        return cantidad_insumo;
    }

    public void setCantidad_insumo(long cantidad_insumo) {
        this.cantidad_insumo = cantidad_insumo;
    }
}
