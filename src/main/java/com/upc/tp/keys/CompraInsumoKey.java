package com.upc.tp.keys;

import com.upc.tp.entities.Compra;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;
@Embeddable
public class CompraInsumoKey implements Serializable {
    //@Column(name = "compra_id")
    private Long compraId;
    //@Column(name = "insumo_id")
    private Long insumoId;

    public CompraInsumoKey() {}

    public CompraInsumoKey(Long compraId, Long insumoId) {
        this.compraId = compraId;
        this.insumoId = insumoId;
    }

    // hashCode y equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompraInsumoKey that = (CompraInsumoKey) o;
        return Objects.equals(compraId, that.compraId) &&
                Objects.equals(insumoId, that.insumoId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(compraId, insumoId);
    }

    public Long getCompra_id() {
        return compraId;
    }

    public void setCompra_id(Long compra_id) {
        this.compraId = compra_id;
    }

    public Long getInsumo_id() {
        return insumoId;
    }

    public void setInsumo_id(Long insumo_id) {
        this.insumoId = insumo_id;
    }
}