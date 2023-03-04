package com.tismart.reto02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.reto02.entity.Escuela;
import com.tismart.reto02.service.jpa.EscuelaService;

@RestController
@RequestMapping("/escuela")
public class EscuelaRestController {
	
	@Autowired
	private EscuelaService serviceEscuela;
	
	@GetMapping("/list")
	public List<Escuela> buscarTodos(){
		return serviceEscuela.buscarTodos();
	}
	
	@PostMapping("/save")
	public Escuela guardar(@RequestBody Escuela escuela) {
		serviceEscuela.guardar(escuela);
		return escuela;
	}
	
	@PutMapping("/edit")
	public Escuela modificar(@RequestBody Escuela escuela) {
		serviceEscuela.guardar(escuela);
		return escuela;
	}
	
	@DeleteMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDESCUELA) {
		serviceEscuela.eliminar(IDESCUELA);
		return "Registro Eliminado";
	}

}
