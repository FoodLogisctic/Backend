package com.upc.tp.controller;

import com.upc.tp.dto.UsuarioDTO;
import com.upc.tp.entities.Usuario;
import com.upc.tp.services.UsuarioService;
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
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @PostMapping("/usuario")
    public ResponseEntity<UsuarioDTO> insert(@RequestBody UsuarioDTO usuarioDTO){
        ModelMapper modelMapper= new ModelMapper();
        Usuario u= modelMapper.map(usuarioDTO, Usuario.class);
        u= usuarioService.insert(u);
        usuarioDTO=modelMapper.map(u,UsuarioDTO.class);
        return new ResponseEntity<UsuarioDTO>(usuarioDTO, HttpStatus.OK);
    }
    @GetMapping("/usuarios") //http://localhost:8080/api/usuarios
    public ResponseEntity<List<UsuarioDTO>> list(){
        List<Usuario> u;
        List<UsuarioDTO> listDto;
        try{
            u= usuarioService.list();
            listDto=u.stream().map(this::convertToDto).collect(Collectors.toList());
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage());
        }
        return new ResponseEntity<List<UsuarioDTO>>(listDto,HttpStatus.OK);
    }
    @PutMapping("/usuario")
    public  ResponseEntity<Usuario> save(@RequestBody Usuario usuario) throws Exception{
        Usuario u;
        try{
            u= usuarioService.save(usuario);
        }catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NO_CONTENT,e.getMessage());
        }
        return new ResponseEntity<Usuario>(u,HttpStatus.OK);
    }
    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable(value = "id")Long id) throws Exception{
     Usuario u;
        u= usuarioService.delete(id);
        return new ResponseEntity<Usuario>(u, HttpStatus.OK);
    }
    private UsuarioDTO convertToDto(Usuario usuario){
        ModelMapper modelMapper= new ModelMapper();
        UsuarioDTO usuarioDTO= modelMapper.map(usuario,UsuarioDTO.class);
        return  usuarioDTO;
    }
}
