package com.upc.tp.entities;

import com.upc.tp.keys.CompraInsumoKey;
import jakarta.persistence.*;

@Entity
public class CompraInsumo {
    @EmbeddedId
    private CompraInsumoKey id;
    @ManyToOne
    @MapsId("compraId")
    @JoinColumn(name = "compra_id")
    private Compra compra;
    @ManyToOne
    @MapsId("insumoId")
    @JoinColumn(name = "insumo_id")
    private Insumo insumo;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private double precioUnit;
    public CompraInsumo(){}
    public CompraInsumo(Compra compra, Insumo insumo, int cantidad,double precioUnit) {
        this.compra = compra;
        this.insumo = insumo;
        this.cantidad = cantidad;
        this.precioUnit=precioUnit;
        this.id = new CompraInsumoKey(compra.getId(), insumo.getId());
    }

    public CompraInsumoKey getId() {
        return id;
    }

    public void setId(CompraInsumoKey id) {
        this.id = id;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnit() {
        return precioUnit;
    }

    public void setPrecioUnit(double precioUnit) {
        this.precioUnit = precioUnit;
    }
}