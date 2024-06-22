package com.upc.tp.services;

import com.upc.tp.entities.Usuario;

import java.util.List;


public interface IUserService {
	public Integer insert(Usuario user);
	public void insertUser(Usuario user);
	public Integer buscarUser(String username);
	List<Usuario> list();
	public Integer insertUserRol(Long user_id, Long rol_id);
	public Integer insertUserRol2(Long user_id, Long rol_id);


}
