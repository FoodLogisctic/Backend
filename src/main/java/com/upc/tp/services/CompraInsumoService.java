package com.upc.tp.services;

import com.upc.tp.dto.CompraInsumoDetailsDTO;
import com.upc.tp.entities.CompraInsumo;
import com.upc.tp.keys.CompraInsumoKey;
import com.upc.tp.repositories.CompraInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraInsumoService {
    @Autowired
    private CompraInsumoRepository compraInsumoRepository;
    public CompraInsumo insert(CompraInsumo compraInsumo){
        return compraInsumoRepository.save(compraInsumo);
    }
    public List<CompraInsumo> list(){
        return compraInsumoRepository.findAll();
    }
    public CompraInsumo searchId(CompraInsumoKey id) throws Exception{
        return compraInsumoRepository.findById(id).orElseThrow(()->new Exception("No hay"));
    }
    public List<CompraInsumoDetailsDTO> listDetails(){return compraInsumoRepository.listDetails();}
    public CompraInsumo save(CompraInsumo compraInsumo)throws Exception{
        searchId(compraInsumo.getId());
        return compraInsumoRepository.save(compraInsumo);
    }
    public CompraInsumo delete(CompraInsumoKey id) throws Exception{ //DELETE
        CompraInsumo compraInsumo;
        compraInsumo=searchId(id);
        compraInsumoRepository.deleteById(id);
        return compraInsumo;
    }
}
