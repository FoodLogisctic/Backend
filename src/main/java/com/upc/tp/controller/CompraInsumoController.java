package com.upc.tp.controller;

import com.upc.tp.dto.CompraInsumoDTO;
import com.upc.tp.dto.CompraInsumoDetailsDTO;
import com.upc.tp.dto.InsumoProveedorDTO;
import com.upc.tp.entities.CompraInsumo;
import com.upc.tp.keys.CompraInsumoKey;
import com.upc.tp.services.CompraInsumoService;
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
public class CompraInsumoController {
    @Autowired
    private CompraInsumoService compraInsumoService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('JEFE VENTAS')")
    /*@PostMapping("/compraInsumo")
    public ResponseEntity<CompraInsumo> insert(@RequestBody CompraInsumo compraInsumo){  //wrapper
        CompraInsumo savedcompraInsumo=compraInsumoService.insert(compraInsumo);
        return new ResponseEntity<>(savedcompraInsumo, HttpStatus.OK);
    }*/
    @PostMapping("/compraInsumo")
    public ResponseEntity<CompraInsumoDTO> insert(@RequestBody CompraInsumoDTO compraInsumoDTO){  //wrapper
        ModelMapper modelMapper=new ModelMapper();
        CompraInsumo compraInsumo =modelMapper.map(compraInsumoDTO,CompraInsumo.class);
        try{
            compraInsumo=compraInsumoService.insert(compraInsumo);
            compraInsumoDTO=modelMapper.map(compraInsumo,CompraInsumoDTO.class);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<CompraInsumoDTO>(compraInsumoDTO, HttpStatus.OK);
    }

    private CompraInsumoDTO convertToDTO(CompraInsumo compraInsumo){
        ModelMapper modelMapper =new ModelMapper();
        CompraInsumoDTO compraInsumoDTO=modelMapper.map(compraInsumo,CompraInsumoDTO.class);
        return compraInsumoDTO;
    }

    @GetMapping("/compraInsumos")
    public ResponseEntity<List<CompraInsumoDTO>> list(){ //wrapper
        List<CompraInsumo> l;
        List<CompraInsumoDTO> listDto;
        try{
            l = compraInsumoService.list();
            listDto=l.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<CompraInsumoDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/ciDetails")
    public ResponseEntity<List<CompraInsumoDetailsDTO>> listDetails(){ //wrapper
        List<CompraInsumoDetailsDTO> list = compraInsumoService.listDetails();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }

    @PutMapping("/compraInsumo")
    public ResponseEntity<CompraInsumo> save(@RequestBody CompraInsumo compraInsumo) throws Exception{
        CompraInsumo a;
        try{
            a = compraInsumoService.save(compraInsumo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<CompraInsumo>(a,HttpStatus.OK);
    }

    @DeleteMapping("/compraInsumo/{id}")
    public ResponseEntity<CompraInsumo> delete(@PathVariable(value="id") CompraInsumoKey id) throws Exception{
        CompraInsumo a;
        try{
            a = compraInsumoService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<CompraInsumo>(a,HttpStatus.OK);
    }
}
