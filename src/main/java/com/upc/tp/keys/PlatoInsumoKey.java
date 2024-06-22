package com.upc.tp.keys;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PlatoInsumoKey implements Serializable {
    @Column(name = "plato_id")
    private Long platoId;
    @Column(name = "insumo_id")
    private Long insumoId;
    public PlatoInsumoKey() {}

    public PlatoInsumoKey(Long platoId, Long insumoId) {
        this.platoId = platoId;
        this.insumoId = insumoId;
    }

    // hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlatoInsumoKey that = (PlatoInsumoKey) o;
        return Objects.equals(platoId, that.platoId) &&
                Objects.equals(insumoId, that.insumoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(platoId, insumoId);
    }

    public Long getPlatoId() {
        return platoId;
    }

    public void setPlatoId(Long platoId) {
        this.platoId = platoId;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }
}
