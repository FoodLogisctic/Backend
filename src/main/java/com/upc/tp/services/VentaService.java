package com.upc.tp.services;

import com.upc.tp.entities.Venta;
import com.upc.tp.repositories.VentaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentaService {
    @Autowired
    private VentaRepository ventaRepository;
    public Venta insert(Venta venta){return ventaRepository.save(venta);}
    public List<Venta> list(){return ventaRepository.findAll();}
    public Venta searchId(Long id) throws Exception{
        return ventaRepository.findById(id).orElseThrow(() -> new Exception("No se encuentra"));
    }
    public Venta save(Venta venta) throws Exception{
        searchId(venta.getId());
        return ventaRepository.save(venta);
    }
    public Venta delete(Long id) throws Exception{
        Venta v;
        v = searchId(id);
        ventaRepository.deleteById(id);
        return v;
    }
    public List<Venta> listVentasFecha(LocalDate fecha){
        return ventaRepository.findVentasByFecha(fecha);
    }
    public List<Venta> listVentasMonto(double monto){
        return ventaRepository.findVentasByMontoIsGreaterThanEqual(monto);
    }
    public List<Venta> listVentasMes(LocalDate fecha1,LocalDate fecha2){
        return ventaRepository.findVentasByFechaIsBetween(fecha1,fecha2);
    }
}
