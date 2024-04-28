package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class PlatoDTO {
    private Long id;
    private String namePlato;
    private  String categoriaPlato;
    private float precio;
}