package com.upc.tp.repositories;

import com.upc.tp.entities.PlatoInsumo;
import com.upc.tp.keys.PlatoInsumoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlatoInsumoRepository extends JpaRepository<PlatoInsumo, PlatoInsumoKey> {
}
