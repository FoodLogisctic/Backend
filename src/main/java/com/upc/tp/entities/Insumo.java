package com.upc.tp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private int cantidad;
    @Column(nullable = false)
    private String tipo;
    @Column
    private char perecible;
    @Column
    private LocalDate fechaVencimiento;

    @OneToMany(mappedBy = "insumo")
    private Set<CompraInsumo> compraInsumos;
}
