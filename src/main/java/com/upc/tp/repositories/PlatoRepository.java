package com.upc.tp.repositories;

import com.upc.tp.dto.InsumoPlatoDTO;
import com.upc.tp.entities.Plato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository

public interface PlatoRepository extends JpaRepository<Plato, Long> {
    @Query("select new com.upc.tp.dto.InsumoPlatoDTO(p.namePlato,i.nombre,pi.cantidad_insumo) from Insumo i join PlatoInsumo pi on pi.insumo.id=i.id " +
            "join Plato p on pi.plato.id=p.id where p.namePlato=:plato group by  p.namePlato,i.nombre,pi.cantidad_insumo")
    List<InsumoPlatoDTO> listInsumosPlato(@Param("plato") String plato);
}
