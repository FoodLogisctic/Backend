package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoPlatoDTO {
    private String nombrePlato;
    private String nombreInsumo;
    private long cantidad;
}
