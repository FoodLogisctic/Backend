package com.upc.tp.repositories;

import com.upc.tp.entities.VentaPlato;
import com.upc.tp.keys.VentaPlatoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VentaPlatoRepository extends JpaRepository<VentaPlato, VentaPlatoKey> {
}