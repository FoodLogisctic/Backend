package com.upc.tp.repositories;

import com.upc.tp.entities.Venta;
import com.upc.tp.entities.VentaPlato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface VentaRepository extends JpaRepository<Venta,Long> {
    List<Venta> findVentasByFecha(LocalDate fecha);
    List<Venta> findVentasByMontoIsGreaterThanEqual(double monto);
    List<Venta> findVentasByFechaIsBetween(LocalDate fecha1,LocalDate fecha2);
}
