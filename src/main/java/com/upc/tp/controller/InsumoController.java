package com.upc.tp.controller;

import com.upc.tp.dto.InsumoCantidadDTO;
import com.upc.tp.dto.InsumoDTO;
import com.upc.tp.dto.InsumoFechaDTO;
import com.upc.tp.dto.InsumoProveedorDTO;
import com.upc.tp.entities.Insumo;
import com.upc.tp.services.InsumoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://localhost:4200"})

@RestController
@RequestMapping("/api")
public class InsumoController {
    @Autowired
    private InsumoService insumoService;

    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('JEFE VENTAS') or hasAuthority('JEFE COCINA')")
    @PostMapping("/insumo")
    public ResponseEntity<InsumoDTO> insert(@RequestBody InsumoDTO insumoDTO){
        ModelMapper modelMapper=new ModelMapper();
        Insumo insumo =modelMapper.map(insumoDTO,Insumo.class);
        try{
            insumo=insumoService.insert(insumo);
            insumoDTO=modelMapper.map(insumo,InsumoDTO.class);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<InsumoDTO>(insumoDTO, HttpStatus.OK);
    }

    private InsumoDTO convertToDTO(Insumo insumo){
        ModelMapper modelMapper =new ModelMapper();
        InsumoDTO insumoDTO=modelMapper.map(insumo,InsumoDTO.class);
        return insumoDTO;
    }

    @GetMapping("/insumos")
    public ResponseEntity<List<InsumoDTO>> list(){
        List<Insumo> l;
        List<InsumoDTO> listDto;
        try{
            l = insumoService.list();
            listDto=l.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<InsumoDTO>>(listDto,HttpStatus.OK);
    }

    @PutMapping("/insumo")
    public ResponseEntity<Insumo> save(@RequestBody Insumo insumo) throws Exception{
        Insumo a;
        try{
            a = insumoService.save(insumo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Insumo>(a,HttpStatus.OK);
    }

    @DeleteMapping("/insumo/{id}")
    public ResponseEntity<Insumo> delete(@PathVariable(value="id")Long id) throws Exception{
        Insumo a;
        try{
            a = insumoService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Insumo>(a,HttpStatus.OK);
    }
    @GetMapping("/insumosCantidad")
    public ResponseEntity<List<InsumoCantidadDTO>> listInsumosCantidad(){ //wrapper
        List<InsumoCantidadDTO> list = insumoService.listInsumoCantidad();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/insumosProveedor")
    public ResponseEntity<List<InsumoProveedorDTO>> listInsumosProveedor(){ //wrapper
        List<InsumoProveedorDTO> list = insumoService.listInsumoProveedor();
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/insumosFecha/{fecha}")
    public ResponseEntity<List<InsumoFechaDTO>> listInsumosFecha(@PathVariable(value = "fecha")LocalDate fecha){
        List<InsumoFechaDTO> list=insumoService.listInsumoFecha(fecha);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/insumo/{id}")
    public ResponseEntity<InsumoDTO> obtenerEntidad(@PathVariable(value = "id") Long id){
        Insumo insumo;
        InsumoDTO insumoDTO;
        try {
            insumo = insumoService.searchId(id);
            insumoDTO = convertToDto(insumo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return new ResponseEntity<InsumoDTO>(insumoDTO, HttpStatus.OK);
    }
    private InsumoDTO convertToDto(Insumo insumo) {
        ModelMapper modelMapper = new ModelMapper();
        InsumoDTO insumoDTO = modelMapper.map(insumo, InsumoDTO.class);
        return insumoDTO;
    }
}
