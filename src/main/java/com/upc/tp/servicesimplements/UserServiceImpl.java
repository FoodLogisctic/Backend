package com.upc.tp.servicesimplements;

import com.upc.tp.entities.Role;
import com.upc.tp.entities.Usuario;
import com.upc.tp.repositories.RoleRepository;
import com.upc.tp.repositories.UsuarioRepository;
import com.upc.tp.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private UsuarioRepository uR;
	@Autowired
	private RoleRepository rR;

	@Transactional
	@Override
	public Integer insert(Usuario user) {
		int rpta = uR.buscarUsername(user.getUsername());
		if (rpta == 0) {
			uR.save(user);
		}
		return rpta;
	}
	public Integer buscarUser(String username){
		int rpta = uR.buscarUsername(username);
		return rpta;
	}
	@Transactional
	@Override
	public void insertUser(Usuario user) {
		user.setEnabled(true);
		uR.save(user);
	}
	@Transactional
	public void insertUser2(Usuario user) {
		user.setEnabled(true);
		uR.save(user);
		//user.setRoles(Role roles);
	}

	@Override
	public List<Usuario> list() {
		// TODO Auto-generated method stub
		return uR.findAll();
	}

	/**
	 * @param user_id De un usuario existente
	 * @param rol_id  De un usuario existente
	 * @return 1 exito
	 */
	@Override
	public Integer insertUserRol(Long user_id, Long rol_id) {
		Integer result = 0;
		uR.insertUserRol(user_id, rol_id);
		return 1;
	}

	@Transactional
	public Integer insertUserRol2(Long user_id, Long rol_id) {
		Integer result = 0;
		Usuario user = uR.findById(user_id).get();
		Role role = rR.findById(rol_id).get();
		user.getRoles().add(role);
		uR.save(user);
		rR.save(role);
		return 1;
	}

	public Usuario searchId( Long id) throws Exception{
		return uR.findById(id).orElseThrow(()-> new Exception("No existe"));
	}
	public Usuario save(Usuario usuario) throws Exception{
		searchId(usuario.getId());
		return uR.save(usuario);
	}
	public Usuario delete(Long id) throws  Exception{
		Usuario u;
		u= searchId(id);
		uR.deleteById(id);
		return u;
	}
}
