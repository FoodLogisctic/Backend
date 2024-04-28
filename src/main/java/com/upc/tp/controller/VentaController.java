package com.upc.tp.controller;

import com.upc.tp.dto.VentaDTO;
import com.upc.tp.entities.Venta;
import com.upc.tp.entities.Venta;
import com.upc.tp.services.VentaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api")
public class VentaController {
    @Autowired
    private VentaService ventaService;
    private VentaDTO convertToDto(Venta venta){
        ModelMapper modelMapper = new ModelMapper();
        VentaDTO ventaDTO = modelMapper.map(venta, VentaDTO.class);
        return ventaDTO;
    }
    @PostMapping("/venta")
    public ResponseEntity<VentaDTO> insert(@RequestBody VentaDTO ventaDTO){
        ModelMapper modelMapper = new ModelMapper();
        Venta v = modelMapper.map(ventaDTO, Venta.class);
        v = ventaService.insert(v);
        ventaDTO = modelMapper.map(v,VentaDTO.class);
        return new ResponseEntity<VentaDTO>(ventaDTO, HttpStatus.OK);
    }
    @GetMapping("/ventas")
    public ResponseEntity<List<VentaDTO>> list(){
        List<Venta> l;
        List<VentaDTO> listDto;
        try {
            l = ventaService.list();
            listDto = l.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<VentaDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/venta")
    public ResponseEntity<Venta> save(@RequestBody Venta venta) throws Exception{
        Venta a;
        try{
            a = ventaService.save(venta);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Venta>(a,HttpStatus.OK);
    }

    @DeleteMapping("/venta/{id}")
    public ResponseEntity<Venta> delete(@PathVariable(value="id") Long id) throws Exception{
        Venta a;
        try{
            a = ventaService.delete(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<Venta>(a,HttpStatus.OK);
    }
    @GetMapping("/ventasFecha/{fecha}") //http://localhost:8080/api/authors
    public ResponseEntity<List<VentaDTO>> listVentaFecha(@PathVariable(value = "fecha")LocalDate fecha){ //wrapper
        List<Venta> l;
        List<VentaDTO> listDto;
        try {
            l = ventaService.listVentasFecha(fecha);
            listDto = l.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<VentaDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/ventasMonto/{monto}") //http://localhost:8080/api/authors
    public ResponseEntity<List<VentaDTO>> listVentaMonto(@PathVariable(value = "monto")double monto){ //wrapper
        List<Venta> l;
        List<VentaDTO> listDto;
        try {
            l = ventaService.listVentasMonto(monto);
            listDto = l.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<VentaDTO>>(listDto,HttpStatus.OK);
    }
    @GetMapping("/ventasFechas/{fecha1}/{fecha2}") //http://localhost:8080/api/authors
    public ResponseEntity<List<VentaDTO>> listVentasMes(@PathVariable(value = "fecha1")LocalDate fecha1,
                                                         @PathVariable(value = "fecha2")LocalDate fecha2){ //wrapper
        List<Venta> l;
        List<VentaDTO> listDto;
        try {
            l = ventaService.listVentasMes(fecha1,fecha2);
            listDto = l.stream()
                    .map(this::convertToDto)
                    .collect(Collectors.toList());
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,e.getMessage());
        }
        return new ResponseEntity<List<VentaDTO>>(listDto,HttpStatus.OK);
    }

}
