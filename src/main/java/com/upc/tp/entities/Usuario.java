package com.upc.tp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 60, nullable = false)
    private String nombreUsuario;
    @Column(length = 60, nullable = false)
    private String rolUsuario;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String contraseña;
}
