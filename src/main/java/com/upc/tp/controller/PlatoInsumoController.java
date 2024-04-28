package com.upc.tp.controller;

import com.upc.tp.dto.PlatoInsumoDTO;
import com.upc.tp.entities.PlatoInsumo;
import com.upc.tp.keys.PlatoInsumoKey;
import com.upc.tp.services.PlatoInsumoService;
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
public class PlatoInsumoController {
    @Autowired
    private PlatoInsumoService platoInsumoService;

    @PostMapping("/platoInsumo")
    public ResponseEntity<PlatoInsumoDTO> insert(@RequestBody PlatoInsumoDTO platoInsumoDTO){  //wrapper
        ModelMapper modelMapper=new ModelMapper();
        PlatoInsumo platoInsumo = modelMapper.map(platoInsumoDTO,PlatoInsumo.class);
        try{
            platoInsumo=platoInsumoService.register(platoInsumo);
            platoInsumoDTO=modelMapper.map(platoInsumo,PlatoInsumoDTO.class);
        }catch(Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
        }
        return new ResponseEntity<PlatoInsumoDTO>(platoInsumoDTO, HttpStatus.OK);
    }

    private PlatoInsumoDTO convertToDTO(PlatoInsumo platoInsumo){
        ModelMapper modelMapper =new ModelMapper();
        PlatoInsumoDTO platoInsumoDTO=modelMapper.map(platoInsumo,PlatoInsumoDTO.class);
        return platoInsumoDTO;
    }

    @GetMapping("/platoInsumos")
    public ResponseEntity<List<PlatoInsumoDTO>> list(){ //wrapper
        List<PlatoInsumo> l;
        List<PlatoInsumoDTO> listDto;
        try{
            l = platoInsumoService.list();
            listDto=l.stream()
                    .map(this::convertToDTO)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<PlatoInsumoDTO>>(listDto,HttpStatus.OK);
    }

    @PutMapping("/platoInsumo")
    public ResponseEntity<PlatoInsumo> save(@RequestBody PlatoInsumo platoInsumo) throws Exception{
        PlatoInsumo a;
        try{
            a = platoInsumoService.save(platoInsumo);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<PlatoInsumo>(a,HttpStatus.OK);
    }

    @DeleteMapping("/platoInsumo/{id}")
    public ResponseEntity<PlatoInsumo> delete(@PathVariable(value="id") PlatoInsumoKey id) throws Exception{
        PlatoInsumo a;
        try{
            a = platoInsumoService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<PlatoInsumo>(a,HttpStatus.OK);
    }
}
