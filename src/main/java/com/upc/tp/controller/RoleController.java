package com.upc.tp.controller;

import com.upc.tp.dto.PlatoDTO;
import com.upc.tp.dto.RoleDTO;
import com.upc.tp.dto.RoleDTO;
import com.upc.tp.entities.Plato;
import com.upc.tp.entities.Role;
import com.upc.tp.entities.Role;
import com.upc.tp.services.IRoleService;
import com.upc.tp.services.IUserService;
import com.upc.tp.servicesimplements.RoleServiceImpl;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins ={"http://localhost:4200"})

@RestController
//@SessionAttributes
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private IUserService uService;
	@Autowired
	private IRoleService rService;

	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Role());
		model.addAttribute("listaRoles", uService.list());
		return "role/role";
	}

	@PostMapping("/save")
	public String saveRole(@Validated Role role, BindingResult result, Model model, SessionStatus status) throws Exception {
		if (result.hasErrors()) {
			return "role/role";
		} else {
			rService.insert(role);
			model.addAttribute("mensaje", "Se guardó correctamente");
			status.setComplete();
		}
		model.addAttribute("listaRoles", rService.list());

		return "role/role";

	}

	@GetMapping("/list")
	public String listRole(Model model) {
		try {
			model.addAttribute("role", new Role());
			model.addAttribute("listaRoles", rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "role/listRole";
	}
	@GetMapping("/listar")
	public ResponseEntity<List<Role>> list() {
		return new ResponseEntity<List<Role>>(rService.list(), HttpStatus.OK);
	}
	private RoleDTO convertToDto(Role role) {
		ModelMapper modelMapper = new ModelMapper();
		RoleDTO roleDTO = modelMapper.map(role, RoleDTO.class);
		return roleDTO;
	}
}
