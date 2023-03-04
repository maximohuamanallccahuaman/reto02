package com.tismart.reto02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tismart.reto02.entity.Facultad;
import com.tismart.reto02.service.IFacultadService;

@RestController
@RequestMapping("/facultad")
public class FacultadRestController {

	@Autowired
	private IFacultadService serviceFacultad;
	
	@GetMapping("/list")
	public List<Facultad> buscarTodos(){
		return serviceFacultad.buscarTodos();
	}
	
	@PostMapping("/save")
	public Facultad guardar(@RequestBody Facultad facultad) {
		serviceFacultad.guardar(facultad);
		return facultad;
	}
	
	@PutMapping("/edit")
	public Facultad modificar(@RequestBody Facultad facultad) {
		serviceFacultad.guardar(facultad);
		return facultad;
	}
	
	@DeleteMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDFACULTAD) {
		serviceFacultad.eliminar(IDFACULTAD);
		return "Registro Eliminado";
	}
}
