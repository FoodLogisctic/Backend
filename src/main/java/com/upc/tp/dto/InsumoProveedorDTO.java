package com.upc.tp.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.w3c.dom.ls.LSInput;

import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InsumoProveedorDTO {
    private String nombreProveedor;
    private String nombreInsumo;
}
