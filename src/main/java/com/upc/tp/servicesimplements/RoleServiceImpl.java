package com.upc.tp.servicesimplements;

import com.upc.tp.entities.Role;
import com.upc.tp.repositories.RoleRepository;
import com.upc.tp.services.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
public class RoleServiceImpl implements IRoleService {
	@Autowired
	private RoleRepository rR;

	@Transactional
	@Override
	public Role insert(Role role) {
		return rR.save(role);
	}

	@Override
	public List<Role> list() {
		// TODO Auto-generated method stub
		return rR.findAll();
	}
}
