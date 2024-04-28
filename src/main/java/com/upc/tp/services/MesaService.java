package com.upc.tp.services;

import com.upc.tp.entities.Mesa;
import com.upc.tp.repositories.MesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MesaService {
    @Autowired
    private MesaRepository mesaRepository;
    public Mesa insert(Mesa mesa){return mesaRepository.save(mesa);}
    public List<Mesa> list(){return mesaRepository.findAll();}
    public Mesa searchId(Long id) throws Exception{
        return mesaRepository.findById(id).orElseThrow(()-> new Exception("No se encontro"));
    }
    public Mesa save(Mesa mesa) throws Exception{
        searchId(mesa.getId());
        return mesaRepository.save(mesa);
    }
    public Mesa delete(Long id) throws Exception{
        Mesa m;
        m = searchId(id);
        mesaRepository.deleteById(id);
        return m;
    }
}