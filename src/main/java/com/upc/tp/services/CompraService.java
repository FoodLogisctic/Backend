package com.upc.tp.services;

import com.upc.tp.entities.Compra;
import com.upc.tp.repositories.CompraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompraService {
    @Autowired
    private CompraRepository compraRepository;
    public Compra insert(Compra compra){
        return compraRepository.save(compra);
    }
    public List<Compra> list(){
        return compraRepository.findAll();
    }
    public Compra searchId(Long id) throws Exception{
        return compraRepository.findById(id).orElseThrow(()->new Exception("No hay"));
    }
    public Compra save(Compra compra)throws Exception{
        searchId(compra.getId());
        return compraRepository.save(compra);
    }
    public Compra delete(Long id) throws Exception{ //DELETE
        Compra compra;
        compra=searchId(id);
        compraRepository.deleteById(id);
        return compra;
    }
}
