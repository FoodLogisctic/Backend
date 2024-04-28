package com.upc.tp.services;

import com.upc.tp.dto.InsumoCantidadDTO;
import com.upc.tp.dto.InsumoFechaDTO;
import com.upc.tp.dto.InsumoProveedorDTO;
import com.upc.tp.entities.Insumo;
import com.upc.tp.repositories.InsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class InsumoService {
    @Autowired
    private InsumoRepository insumoRepository;
    public Insumo insert(Insumo insumo){
        return insumoRepository.save(insumo);
    }
    public List<Insumo> list(){
        return insumoRepository.findAll();
    }
    public Insumo searchId(Long id) throws Exception{
        return insumoRepository.findById(id).orElseThrow(()->new Exception("No hay"));
    }
    public Insumo save(Insumo insumo)throws Exception{
        searchId(insumo.getId());
        return insumoRepository.save(insumo);
    }
    public Insumo delete(Long id) throws Exception{ //DELETE
        Insumo insumo;
        insumo=searchId(id);
        insumoRepository.deleteById(id);
        return insumo;
    }
    public List<InsumoCantidadDTO> listInsumoCantidad(){
        return insumoRepository.listaInsumosCantidad();
    }
    public List<InsumoProveedorDTO> listInsumoProveedor(){
        return insumoRepository.listaInsumosProveedor();
    }
    public List<InsumoFechaDTO> listInsumoFecha(LocalDate fecha){return insumoRepository.listInsumoFecha(fecha);}
}
