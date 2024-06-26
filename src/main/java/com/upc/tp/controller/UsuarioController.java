package com.upc.tp.controller;

import com.upc.tp.dto.UsuarioDTO;
import com.upc.tp.entities.Usuario;
import com.upc.tp.services.IUserService;
import com.upc.tp.services.UsuarioService;
import com.upc.tp.servicesimplements.UserServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
@CrossOrigin(origins = {"http://localhost:4200"})

@RestController
//@Secured({"ADMIN"})
@RequestMapping("/users")
public class UsuarioController {
    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private PasswordEncoder bcrypt;
    @Autowired
    private UserServiceImpl userService;
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
    private UsuarioDTO convertToDto(Usuario usuario) {
        ModelMapper modelMapper = new ModelMapper();
        UsuarioDTO usuarioDTO = modelMapper.map(usuario, UsuarioDTO.class);
        return usuarioDTO;
    }
    @PostMapping("/save")
    public ResponseEntity<Integer> saveUser(@RequestBody Usuario user) {
        if (userService.buscarUser(user.getUsername()) == 0) {
            String bcryptPassword = bcrypt.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            userService.insertUser(user);
            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }
        return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
    }
    /*@PostMapping("/save2")
    public ResponseEntity<Integer> saveUser(@RequestBody Usuario user) {
        if (userService.buscarUser(user.getUsername()) == 0) {
            String bcryptPassword = bcrypt.encode(user.getPassword());
            user.setPassword(bcryptPassword);
            userService.insertUser(user);
            return new ResponseEntity<Integer>(1, HttpStatus.OK);
        }
        return new ResponseEntity<Integer>(0, HttpStatus.BAD_REQUEST);
    }*/
    @PostMapping("/save/{user_id}/{rol_id}")
    //@PreAuthorize("hasAuthority('ADMIN')")
    public ResponseEntity<Integer> saveUseRol(@PathVariable("user_id") Long user_id,
                                              @PathVariable("rol_id") Long rol_id){
        return new ResponseEntity<Integer>(userService.insertUserRol(user_id, rol_id),HttpStatus.OK);
        //return new ResponseEntity<Integer>(uService.insertUserRol2(user_id, rol_id),HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Usuario>> getUsers(){
        return new ResponseEntity<>(userService.list(),HttpStatus.OK);
    }
}
