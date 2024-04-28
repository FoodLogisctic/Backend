package com.upc.tp.services;

import com.upc.tp.entities.PlatoInsumo;
import com.upc.tp.keys.PlatoInsumoKey;
import com.upc.tp.repositories.PlatoInsumoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PlatoInsumoService {
    @Autowired
    private PlatoInsumoRepository platoInsumoRepository;
    //1.-
    public PlatoInsumo register(PlatoInsumo platoInsumo){
        return platoInsumoRepository.save(platoInsumo);
    }
    //2.-
    public List<PlatoInsumo> list(){
        return  platoInsumoRepository.findAll();
    }
    public PlatoInsumo searchId(PlatoInsumoKey id) throws Exception{
        return platoInsumoRepository.findById(id).orElseThrow(()->new Exception("No hay"));
    }
    public PlatoInsumo save(PlatoInsumo platoInsumo)throws Exception{
        searchId(platoInsumo.getId());
        return platoInsumoRepository.save(platoInsumo);
    }
    public PlatoInsumo delete(PlatoInsumoKey id) throws Exception{ //DELETE
        PlatoInsumo platoInsumo;
        platoInsumo=searchId(id);
        platoInsumoRepository.deleteById(id);
        return platoInsumo;
    }
}
