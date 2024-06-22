package com.upc.tp.repositories;

import com.upc.tp.dto.CompraInsumoDetailsDTO;
import com.upc.tp.dto.PlatoInsumoDetails;
import com.upc.tp.entities.PlatoInsumo;
import com.upc.tp.keys.PlatoInsumoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlatoInsumoRepository extends JpaRepository<PlatoInsumo, PlatoInsumoKey> {
    @Query("select new com.upc.tp.dto.PlatoInsumoDetails(pi.plato.namePlato,pi.insumo.nombre,pi.cantidad_insumo) from PlatoInsumo pi")
    List<PlatoInsumoDetails> listDetails();
}
