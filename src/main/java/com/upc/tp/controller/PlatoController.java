package com.upc.tp.controller;

import com.upc.tp.dto.InsumoPlatoDTO;
import com.upc.tp.dto.PlatoDTO;
import com.upc.tp.entities.Plato;
import com.upc.tp.services.PlatoService;
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
public class PlatoController {
    @Autowired
    private PlatoService platoService;
    @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('JEFE VENTAS') or hasAuthority('JEFE COCINA')")
    @PostMapping("/plato")
    public ResponseEntity<PlatoDTO> insert(@RequestBody PlatoDTO platoDTO) {
        ModelMapper modelMapper = new ModelMapper();
        Plato p = modelMapper.map(platoDTO, Plato.class);
        p = platoService.insert(p);
        platoDTO = modelMapper.map(p, PlatoDTO.class);
        return new ResponseEntity<PlatoDTO>(platoDTO, HttpStatus.OK);
    }

    @GetMapping("/platos")
    public ResponseEntity<List<PlatoDTO>> list() {
        List<Plato> p;
        List<PlatoDTO> listDto;
        try {
            p = platoService.list();
            listDto = p.stream().map(this::convertToDto).collect(Collectors.toList());
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<List<PlatoDTO>>(listDto, HttpStatus.OK);
    }

    @PutMapping("/plato")
    public ResponseEntity<Plato> save(@RequestBody Plato plato) throws Exception {
        Plato p;
        try {
            p = platoService.save(plato);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                    e.getMessage());
        }

        return new ResponseEntity<Plato>(p, HttpStatus.OK);
    }
    @DeleteMapping("/plato{id}")
    public ResponseEntity<Plato> delete(@PathVariable(value = "id") Long id) throws Exception {
        Plato p;
        p = platoService.delete(id);
        return new ResponseEntity<Plato>(p, HttpStatus.OK);
    }

    private PlatoDTO convertToDto(Plato plato) {
        ModelMapper modelMapper = new ModelMapper();
        PlatoDTO platoDTO = modelMapper.map(plato, PlatoDTO.class);
        return platoDTO;
    }
    @GetMapping("/platosInsumo/{plato}")
    public ResponseEntity<List<InsumoPlatoDTO>> listInsumosPlato(@PathVariable(value = "plato") String plato){
        List<InsumoPlatoDTO> list=platoService.listInsumosPlatos(plato);
        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    @GetMapping("/plato/{id}")
    public ResponseEntity<PlatoDTO> obtenerEntidad(@PathVariable(value = "id") Long id){
        Plato plato;
        PlatoDTO platoDTO;
        try {
            plato = platoService.searchId(id);
            platoDTO = convertToDto(plato);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Mi mensaje");
        }
        return new ResponseEntity<PlatoDTO>(platoDTO, HttpStatus.OK);
    }
}
