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
public class VentaPlatoKey implements Serializable {
    @Column(name = "plato_id")
    private Long platoId;
    @Column(name = "venta_id")
    private Long ventaId;
}
