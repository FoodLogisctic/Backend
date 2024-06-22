package com.upc.tp.controller;

import com.upc.tp.dto.MesaDTO;
import com.upc.tp.entities.Mesa;
import com.upc.tp.services.MesaService;
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
public class MesaController {
    @Autowired
    private MesaService mesaService;
    private MesaDTO convertToDto(Mesa mesa){
        ModelMapper modelMapper = new ModelMapper();
        MesaDTO mesaDTO = modelMapper.map(mesa, MesaDTO.class);
        return mesaDTO;
    }
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('MOZO')")
    @PostMapping("/mesa")
    public ResponseEntity<MesaDTO> insert(@RequestBody MesaDTO mesaDTO){
        ModelMapper modelMapper = new ModelMapper();
        Mesa m = modelMapper.map(mesaDTO, Mesa.class);
        m = mesaService.insert(m);
        mesaDTO = modelMapper.map(m,MesaDTO.class);
        return new ResponseEntity<MesaDTO>(mesaDTO, HttpStatus.OK);
    }

    @GetMapping("/mesas")
    public ResponseEntity<List<MesaDTO>> list(){
        List<Mesa> l;
        List<MesaDTO> listDto;
        try {
            l = mesaService.list();
            listDto = l.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<MesaDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/mesa")
    public ResponseEntity<Mesa> save(@RequestBody Mesa mesa) throws Exception{
        Mesa m;
        try {
            m = mesaService.save(mesa);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Mesa>(m,HttpStatus.OK);
    }
    @DeleteMapping("/mesa/{id}")
    public ResponseEntity<Mesa> delete(@PathVariable(value = "id") Long id) throws Exception {
        Mesa m;
        m = mesaService.delete(id);
        return new ResponseEntity<Mesa>(m, HttpStatus.OK);
    }

    @GetMapping("/mesa/{id}")
    public ResponseEntity<MesaDTO> obtenerEntidad(@PathVariable(value = "id") Long id){
        Mesa mesa;
        MesaDTO mesaDTO;
        try {
            mesa = mesaService.searchId(id);
            mesaDTO = convertToDto(mesa);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return new ResponseEntity<MesaDTO>(mesaDTO, HttpStatus.OK);
    }
}
