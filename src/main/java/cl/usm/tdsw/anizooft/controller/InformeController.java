package cl.usm.tdsw.anizooft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.model.Reserva;
import cl.usm.tdsw.anizooft.service.MascotaService;

@Controller
@RequestMapping(value="/Informe")
public class InformeController {

	@Autowired
	private MascotaService mascotaService;
	
	//Se llama al cargar la pagina informe
	@RequestMapping(value="/Mascota", method=RequestMethod.GET)
	public ModelAndView mascotaGet(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		m.addObject("mascotaList", mascotaService.getAll());
		
		return m;
	}
	
	//Se llama al presionar el boton generar informe
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView mascotaPost(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
		
		//TODO: llamar al service y llenar la pagina con los datos del informe
		
		
		return m;
	}
	
}
