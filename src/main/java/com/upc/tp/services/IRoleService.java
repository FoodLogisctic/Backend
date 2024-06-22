package com.upc.tp.services;

import com.upc.tp.entities.Role;

import java.util.List;


public interface IRoleService {
	public Role insert(Role role);

	List<Role> list();

}
