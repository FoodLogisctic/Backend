package com.upc.tp.repositories;

import com.upc.tp.dto.CompraInsumoDetailsDTO;
import com.upc.tp.entities.CompraInsumo;
import com.upc.tp.keys.CompraInsumoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompraInsumoRepository extends JpaRepository<CompraInsumo, CompraInsumoKey> {
    @Query("select new com.upc.tp.dto.CompraInsumoDetailsDTO(ci.compra.proveedor,ci.insumo.nombre,ci.cantidad,ci.precioUnit) from CompraInsumo ci")
    List<CompraInsumoDetailsDTO> listDetails();
}
