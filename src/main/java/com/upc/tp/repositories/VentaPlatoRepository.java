package com.upc.tp.repositories;

import com.upc.tp.dto.PlatoInsumoDetails;
import com.upc.tp.dto.VentaPlatoDetailsDTO;
import com.upc.tp.entities.VentaPlato;
import com.upc.tp.keys.VentaPlatoKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VentaPlatoRepository extends JpaRepository<VentaPlato, VentaPlatoKey> {
    @Query("select new com.upc.tp.dto.VentaPlatoDetailsDTO(vp.plato.namePlato,vp.venta.fecha,vp.venta.monto,vp.cantidad,vp.observaciones) from VentaPlato vp")
    List<VentaPlatoDetailsDTO> listDetails();
}