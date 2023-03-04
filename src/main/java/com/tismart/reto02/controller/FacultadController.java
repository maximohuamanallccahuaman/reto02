package com.tismart.reto02.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.tismart.reto02.entity.Facultad;
import com.tismart.reto02.service.IFacultadService;

@Controller
@RequestMapping("/facultades")
public class FacultadController {

	@Autowired
	private IFacultadService serviceFacultad;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Facultad> lista = serviceFacultad.buscarTodos();
    	model.addAttribute("facultades", lista);
		return "facultades/listFacultad";		
	}
	
	@GetMapping("/indexPaginate")
	public String mostrarIndexPaginado(Model model, Pageable page) {
		Page<Facultad> lista = serviceFacultad.buscarTodas(page);
		model.addAttribute("facultades", lista);
		return "facultades/listFacultad";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Facultad facultad) {
		return "facultades/formFacultad";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.GET)
	public String guardar(Facultad facultad, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "facultades/formFacultad";
		}
		serviceFacultad.guardar(facultad);
		attributes.addFlashAttribute("msg", "Los datos de la facultad fueron guardados!");		
		return "redirect:/facultades/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int IDFACULTAD, Model model) {		
		Facultad facultad = serviceFacultad.buscarPorId(IDFACULTAD);			
		model.addAttribute("facultad", facultad);
		return "facultades/formFacultad";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDFACULTAD, RedirectAttributes attributes) {		
		serviceFacultad.eliminar(IDFACULTAD);			
		attributes.addFlashAttribute("msg", "La facultad fue eliminada!.");
		return "redirect:/facultades/index";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
