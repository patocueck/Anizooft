package cl.usm.tdsw.anizooft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.model.Due�o;
import cl.usm.tdsw.anizooft.model.Empleado;
import cl.usm.tdsw.anizooft.service.InformeService;
import cl.usm.tdsw.anizooft.service.MascotaService;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;

@Controller
@RequestMapping(value="/Informes")
public class InformeController {

	@Autowired
	private InformeService informeService;
	@Autowired
	private MascotaService mascotaService;
	@Autowired
	private DuenoService due�oService;
	@Autowired
	private EmpleadoService empleadoService;
	
	//Se llama al cargar la p�gina informe
	@RequestMapping(value="/Mascota", method=RequestMethod.GET)
	public ModelAndView informeGet(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		List<VwResumenAtencione> resumenAtenciones = informeService.getAll();
		List<Due�o> due�os = due�oService.getDuenos();
		List<Empleado> empleados = empleadoService.getAll();
				
		m.addObject("mascotaList", resumenAtenciones);
		//m.addObject("mascotaList", mascotas);
		m.addObject("mascota", new Mascota());
		m.addObject("duenos", due�os);
		m.addObject("empleados", empleados);
		
		return m;
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView informePost(
			@ModelAttribute("mascota") Mascota mascota,
			@ModelAttribute("rutDueno")String rutDueno,
			@ModelAttribute("rutEmpleado")String rutEmpleado,	
			@ModelAttribute("idMascota")String idMascota,				
			@ModelAttribute("selectMascota")String selectMascota
			){
		ModelAndView m = new ModelAndView("Informes/Mascota");
		
		Due�o dueno = due�oService.getByRut(rutDueno);
		List<Mascota> mascotas = mascotaService.getMascotas(dueno);
		m.addObject("duenos", due�oService.getDuenos() );
		m.addObject("empleados", empleadoService.getAll());
		m.addObject("mascotas", mascotas);
		m.addObject("rutDueno", rutDueno);
		m.addObject("rutEmpleado", rutEmpleado);
		m.addObject("idMascota", idMascota);
				
		if(selectMascota.equalsIgnoreCase("S")){

			return m;
		}
		
		m.addObject("mascotaList", informeService.getByBusqueda(rutDueno, idMascota, rutEmpleado));
		
		return m;
	}
	
	//Se llama al cargar el form de creacion
	/*
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView historialPost(
			@ModelAttribute("mascota") Mascota mascota,
			@ModelAttribute("rutDue�o")String rutDue�o,
			@ModelAttribute("rutEmpleado")String rutEmpleado,	
			@ModelAttribute("idMascota")String idMascota,				
			@ModelAttribute("selectMascota")String selectMascota
			){
		
		ModelAndView m = new ModelAndView("Informes/Mascota");
		
		Due�o due�o = due�oService.getByRut(rutDue�o);
		List<Mascota> mascotas = mascotaService.getMascotas(due�o);
		m.addObject("due�oList", due�oService.getDuenos());
		m.addObject("empleadoList", empleadoService.getAll());
		m.addObject("mascotaList", mascotas);
		m.addObject("rutDue�o", rutDue�o);
		m.addObject("rutEmpleado", rutEmpleado);
		m.addObject("idMascota", idMascota);
		
		if(selectMascota.equalsIgnoreCase("S")){

			return m;
		}

		m.addObject("resumenAtencionList", informeService.getByBusqueda(rutDue�o, idMascota, rutEmpleado));
		
		return m;
	}
	*/
	
	/*
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView informePost(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		List<VwResumenAtencione> informes = informeService.getAll();
		List<Mascota> mascotas = mascotaService.getAll();
		List<Due�o> due�os = due�oService.getDuenos();
		List<Empleado> empleados = empleadoService.getAll();
		
		m.addObject("informeList", informes);
		m.addObject("mascotaList", mascotas);
		m.addObject("due�oList", due�os);
		m.addObject("empleadoList", empleados);
		
		return m;
	}
	*/
	
}