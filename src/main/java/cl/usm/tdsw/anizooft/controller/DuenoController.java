package cl.usm.tdsw.anizooft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.service.DuenoService;

import java.util.*;

@Controller
@RequestMapping(value="/Dueno")
public class DuenoController {

	@Autowired
	private DuenoService duenoService;
	
	//Se llama al cargar la pagina
	@RequestMapping(value="/Index", method=RequestMethod.GET)
	public ModelAndView indexGet(){
		ModelAndView m = new ModelAndView("Dueno/Index");
			
		List<Dueño> duenos = duenoService.getDuenos();
		
		m.addObject("duenos", duenos);
		
		return m;
	}
	
	//Se llama al presionar el boton buscar
	@RequestMapping(value="/Index", method=RequestMethod.POST)
	public ModelAndView indexPost(){
		ModelAndView m = new ModelAndView("Dueno/Index");
		return m;
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Create", method=RequestMethod.GET)
	public ModelAndView creatGet(){
		ModelAndView m = new ModelAndView("Dueno/Create");
		
		m.addObject("dueno", new Dueño());
		return m;
	}
	
	//Se llama al presionar el boton guardar form.
	@RequestMapping(value="/Create", method=RequestMethod.POST)
	public ModelAndView creatPost(@ModelAttribute("dueno") Dueño dueno){
		ModelAndView mensaje = new ModelAndView("Varios/Mensaje");
		
		//Valida si existe
		Dueño valDueno = duenoService.getByRut(dueno.getRutdueño()) ;
		if (valDueno != null){
			mensaje.addObject("mensaje", "El Dueño indicado ya existe");
			return mensaje;
		}
		
		//Agregar dueño
		duenoService.add(dueno);
		mensaje.addObject("mensaje", "Dueño agregado con éxito.");
		mensaje.addObject("urlRetorno","../Dueno/Index");
		return mensaje;
		
		
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Details", method=RequestMethod.GET)
	public ModelAndView detailsGet(){
		ModelAndView m = new ModelAndView("Dueno/Details");
		return m;
	}
}
