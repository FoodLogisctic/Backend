package com.upc.tp.services;

import com.upc.tp.entities.VentaPlato;
import com.upc.tp.keys.VentaPlatoKey;
import com.upc.tp.repositories.VentaPlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentaPlatoService {
    @Autowired
    private VentaPlatoRepository ventaPlatoRepository;
    //1.-
    public VentaPlato register(VentaPlato ventaPlato){
        return ventaPlatoRepository.save(ventaPlato);
    }
    //2.-
    public List<VentaPlato> list(){
        return  ventaPlatoRepository.findAll();
    }
    public VentaPlato searchId(VentaPlatoKey id) throws Exception{
        return ventaPlatoRepository.findById(id).orElseThrow(()->new Exception("No hay"));
    }
    public VentaPlato save(VentaPlato ventaPlato)throws Exception{
        searchId(ventaPlato.getId());
        return ventaPlatoRepository.save(ventaPlato);
    }
    public VentaPlato delete(VentaPlatoKey id) throws Exception{ //DELETE
        VentaPlato ventaPlato;
        ventaPlato=searchId(id);
        ventaPlatoRepository.deleteById(id);
        return ventaPlato;
    }
}
