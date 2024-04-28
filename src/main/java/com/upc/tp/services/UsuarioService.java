package com.upc.tp.services;

import com.upc.tp.entities.Usuario;
import com.upc.tp.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository usuarioRepository;
    public Usuario insert(Usuario usuario)
    {
        return usuarioRepository.save(usuario);
    }

    public List<Usuario> list(){
        return usuarioRepository.findAll();
    }

    public Usuario searchId( Long id) throws Exception{
        return usuarioRepository.findById(id).orElseThrow(()-> new Exception("No existe"));
    }
    public Usuario save(Usuario usuario) throws Exception{
        searchId(usuario.getId());
        return usuarioRepository.save(usuario);
    }
    public Usuario delete(Long id) throws  Exception{
      Usuario u;
        u= searchId(id);
        usuarioRepository.deleteById(id);
        return u;
    }
}
