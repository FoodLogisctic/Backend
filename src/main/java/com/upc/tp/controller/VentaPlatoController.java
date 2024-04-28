package com.upc.tp.controller;

import com.upc.tp.dto.VentaPlatoDTO;
import com.upc.tp.entities.VentaPlato;
import com.upc.tp.keys.VentaPlatoKey;
import com.upc.tp.services.VentaPlatoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VentaPlatoController {
    @Autowired
    private VentaPlatoService ventaPlatoService;

    @PostMapping("/ventaPlato")
    public ResponseEntity<VentaPlatoDTO> insert(@RequestBody VentaPlatoDTO ventaPlatoDTO){  //wrapper
        ModelMapper modelMapper=new ModelMapper();
        VentaPlato ventaPlato = modelMapper.map(ventaPlatoDTO,VentaPlato.class);
        try{
            ventaPlato=ventaPlatoService.register(ventaPlato);
            ventaPlatoDTO=modelMapper.map(ventaPlato,VentaPlatoDTO.class);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<VentaPlatoDTO>(ventaPlatoDTO, HttpStatus.OK);
    }

    private VentaPlatoDTO convertToDTO(VentaPlato ventaPlato){
        ModelMapper modelMapper =new ModelMapper();
        VentaPlatoDTO ventaPlatoDTO=modelMapper.map(ventaPlato,VentaPlatoDTO.class);
        return ventaPlatoDTO;
    }

    @GetMapping("/ventaPlatos")
    public ResponseEntity<List<VentaPlatoDTO>> list(){ //wrapper
        List<VentaPlato> l;
        List<VentaPlatoDTO> listDto;
        try{
            l = ventaPlatoService.list();
            listDto=l.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<VentaPlatoDTO>>(listDto,HttpStatus.OK);
    }

    @PutMapping("/ventaPlato")
    public ResponseEntity<VentaPlato> save(@RequestBody VentaPlato ventaPlato) throws Exception{
        VentaPlato a;
        try{
            a = ventaPlatoService.save(ventaPlato);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<VentaPlato>(a,HttpStatus.OK);
    }

    @DeleteMapping("/ventaPlato/{id}")
    public ResponseEntity<VentaPlato> delete(@PathVariable(value="id") VentaPlatoKey id) throws Exception{
        VentaPlato a;
        try{
            a = ventaPlatoService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<VentaPlato>(a,HttpStatus.OK);
    }

}