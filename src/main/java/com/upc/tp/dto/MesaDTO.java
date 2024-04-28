package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MesaDTO {
    private int id;
    private int numeroMesa;
    private int capacidadMesa;
}
