package cl.usm.tdsw.anizooft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Empleado;
import cl.usm.tdsw.anizooft.service.InformeService;
import cl.usm.tdsw.anizooft.service.MascotaService;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;

@Controller
@RequestMapping(value="/Informe")
public class InformeController {

	@Autowired
	private InformeService informeService;
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private DuenoService dueñoService;
	@Autowired
	private EmpleadoService empleadoService;
	
	//Se llama al cargar la página informe
	@RequestMapping(value="/Mascota", method=RequestMethod.GET)
	public ModelAndView mascotaGet(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		List<VwResumenAtencione> informes = informeService.getAll();
		List<Mascota> mascotas = mascotaService.getAll();
		List<Dueño> dueños = dueñoService.getDuenos();
		List<Empleado> empleados = empleadoService.getAll();
		
		m.addObject("informeList", informes);
		//m.addObject("mascotaList", mascotas);
		//m.addObject("dueñoList", dueños);
		//m.addObject("empleadoList", empleados);
		
		return m;
	}
	
	/*
	@RequestMapping(value="/Index", method=RequestMethod.GET)
	public ModelAndView indexGet(){
		ModelAndView m = new ModelAndView("Mascota/Index");
			
		List<Mascota> mascotas = mascotaService.getAll();
		
		m.addObject("mascotas", mascotas);
		
		return m;
	}
	*/
	
	//Se llama al presionar el boton generar informe
	/*
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView mascotaPost(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
		
		//TODO: llamar al service y llenar la pagina con los datos del informe
		
		
		return m;
	}
	*/
	
}