package com.upc.tp.repositories;

import com.upc.tp.entities.CompraInsumo;
import com.upc.tp.keys.CompraInsumoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompraInsumoRepository extends JpaRepository<CompraInsumo, CompraInsumoKey> {
}
