package com.upc.tp.controller;

import com.upc.tp.dto.CompraDTO;
import com.upc.tp.entities.Compra;
import com.upc.tp.services.CompraService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://localhost:4200"})

@RestController
@RequestMapping("/api")
public class CompraController {
    @Autowired
    private CompraService compraService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('JEFE VENTAS')")
    @PostMapping("/compra")
    public ResponseEntity<CompraDTO> insert(@RequestBody CompraDTO compraDTO){  //wrapper
        ModelMapper modelMapper=new ModelMapper();
        Compra compra =modelMapper.map(compraDTO,Compra.class);
        try{
            compra=compraService.insert(compra);
            compraDTO=modelMapper.map(compra,CompraDTO.class);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<CompraDTO>(compraDTO, HttpStatus.OK);
    }

    private CompraDTO convertToDTO(Compra compra){
        ModelMapper modelMapper =new ModelMapper();
        CompraDTO compraDTO=modelMapper.map(compra,CompraDTO.class);
        return compraDTO;
    }

    @GetMapping("/compras")
    public ResponseEntity<List<CompraDTO>> list(){ //wrapper
        List<Compra> l;
        List<CompraDTO> listDto;
        try{
            l = compraService.list();
            listDto=l.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<CompraDTO>>(listDto,HttpStatus.OK);
    }

    @PutMapping("/compra")
    public ResponseEntity<Compra> save(@RequestBody Compra compra) throws Exception{
        Compra a;
        try{
            a = compraService.save(compra);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Compra>(a,HttpStatus.OK);
    }

    @DeleteMapping("/compra/{id}")
    public ResponseEntity<Compra> delete(@PathVariable(value="id")Long id) throws Exception{
        Compra a;
        try{
            a = compraService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Compra>(a,HttpStatus.OK);
    }
    @GetMapping("/compra/{id}")
    public ResponseEntity<CompraDTO> obtenerEntidad(@PathVariable(value = "id") Long id){
        Compra compra;
        CompraDTO compraDTO;
        try {
            compra = compraService.searchId(id);
            compraDTO = convertToDto(compra);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return new ResponseEntity<CompraDTO>(compraDTO, HttpStatus.OK);
    }
    private CompraDTO convertToDto(Compra compra) {
        ModelMapper modelMapper = new ModelMapper();
        CompraDTO compraDTO = modelMapper.map(compra, CompraDTO.class);
        return compraDTO;
    }
}
