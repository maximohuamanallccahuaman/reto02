package com.tismart.reto02.controller;

import java.io.FileNotFoundException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
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

import com.tismart.reto02.entity.Escuela;
import com.tismart.reto02.service.IEscuelaService;
import com.tismart.reto02.service.jpa.EscuelaService;

import net.sf.jasperreports.engine.JRException;

@Controller
@RequestMapping("/escuelas")
public class EscuelaController {
	
	@Autowired
	private IEscuelaService serviceEscuela;
	
	@Autowired
	private EscuelaService serEscuela;
	
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String mostrarIndex(Model model) {
		List<Escuela> lista = serviceEscuela.buscarTodos();
    	model.addAttribute("escuelas", lista);
		return "escuelas/listEscuela";		
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String crear(Escuela escuela) {
		return "escuelas/formEscuela";
	}
	
	@RequestMapping(value="/save", method=RequestMethod.POST)
	public String guardar(Escuela escuela, BindingResult result, RedirectAttributes attributes) {
		if (result.hasErrors()){		
			System.out.println("Existieron errores");
			return "escuelas/formEscuela";
		}
		serviceEscuela.guardar(escuela);
		attributes.addFlashAttribute("msg", "Los datos de la escuela fueron guardados!");		
		return "redirect:/escuelas/index";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int IDESCUELA, Model model) {		
		Escuela escuela = serviceEscuela.buscarPorId(IDESCUELA);			
		model.addAttribute("escuela", escuela);
		return "escuelas/formEscuela";
	}
	
	@GetMapping("/delete/{id}")
	public String eliminar(@PathVariable("id") int IDESCUELA, RedirectAttributes attributes) {		
		serviceEscuela.eliminar(IDESCUELA);			
		attributes.addFlashAttribute("msg", "La Escuela fue eliminada!.");
		return "redirect:/escuelas/index";
	}
	
	@GetMapping("/report/{format}")
	public String generateReport(@PathVariable String format) throws FileNotFoundException, JRException {
		return serEscuela.exportReport(format);
	}
	
	@GetMapping("/report1")
	public String getReport1() {
		return "reportes/report1";
	}
	
	@InitBinder
	public void initBinder(WebDataBinder webDataBinder) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		webDataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
	}
}
