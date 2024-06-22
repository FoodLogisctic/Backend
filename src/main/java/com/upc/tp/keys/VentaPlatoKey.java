package com.upc.tp.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class VentaPlatoKey implements Serializable {
    @Column(name = "plato_id")
    private Long platoId;
    @Column(name = "venta_id")
    private Long ventaId;
    public VentaPlatoKey() {}

    public VentaPlatoKey(Long platoId, Long ventaId) {
        this.platoId = platoId;
        this.ventaId = ventaId;
    }

    // hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VentaPlatoKey that = (VentaPlatoKey) o;
        return Objects.equals(platoId, that.platoId) &&
                Objects.equals(ventaId, that.ventaId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platoId, ventaId);
    }

    public Long getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Long platoId) {
        this.platoId = platoId;
    }

    public Long getVentaId() {
        return ventaId;
    }

    public void setVentaId(Long ventaId) {
        this.ventaId = ventaId;
    }
}
