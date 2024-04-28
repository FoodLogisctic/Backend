package com.upc.tp.services;

import com.upc.tp.dto.InsumoPlatoDTO;
import com.upc.tp.entities.Plato;
import com.upc.tp.repositories.PlatoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlatoService {
    @Autowired
    private PlatoRepository platoRepository;
    public Plato insert (Plato plato) {
        return platoRepository.save(plato);
    }

    public List<Plato> list(){return platoRepository.findAll();}
    public Plato searchId (Long id) throws Exception{
        return platoRepository.findById(id).orElseThrow(() -> new Exception("No se encuentra"));
    }

    public Plato save (Plato plato) throws Exception{
        searchId(plato.getId());
        return platoRepository.save(plato);
    }

    public Plato delete (Long id) throws  Exception{
        Plato p;
        p=searchId(id);
        platoRepository.deleteById(id);
        return p;
    }

    public List<InsumoPlatoDTO> listInsumosPlatos(String plato){
        return platoRepository.listInsumosPlato(plato);
    }
}
