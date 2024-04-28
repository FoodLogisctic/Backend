package com.upc.tp.repositories;

import com.upc.tp.dto.InsumoCantidadDTO;
import com.upc.tp.dto.InsumoFechaDTO;
import com.upc.tp.dto.InsumoProveedorDTO;
import com.upc.tp.entities.Insumo;
import org.springframework.cglib.core.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Repository
public interface InsumoRepository extends JpaRepository<Insumo,Long>{
    @Query("select new com.upc.tp.dto.InsumoCantidadDTO(i.nombre,i.cantidad) from Insumo i order by i.cantidad asc")
    List<InsumoCantidadDTO> listaInsumosCantidad();

    @Query("select new com.upc.tp.dto.InsumoProveedorDTO(c.proveedor,i.nombre) from Insumo i join " +
            "CompraInsumo ci on i.id=ci.insumo.id join Compra c on ci.compra.id=c.id group by c.proveedor,i.nombre")
    List<InsumoProveedorDTO> listaInsumosProveedor();
    @Query("select new com.upc.tp.dto.InsumoFechaDTO(i.nombre,c.fecha,c.proveedor,ci.cantidad,i.tipo)  from Insumo i join " +
            "CompraInsumo ci on i.id=ci.insumo.id join Compra c on ci.compra.id=c.id where c.fecha=:fecha group by " +
            "i.nombre,c.fecha,c.proveedor,ci.cantidad,i.tipo")
    List<InsumoFechaDTO> listInsumoFecha(@Param("fecha")LocalDate fecha);
}
