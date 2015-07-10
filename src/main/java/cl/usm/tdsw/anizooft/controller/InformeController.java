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
import cl.usm.tdsw.anizooft.model.Dueño;
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
	private DuenoService dueñoService;
	@Autowired
	private EmpleadoService empleadoService;
	
	//Se llama al cargar la página informe
	@RequestMapping(value="/Mascota", method=RequestMethod.GET)
	public ModelAndView informeGet(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		List<VwResumenAtencione> resumenAtenciones = informeService.getAll();
		List<Dueño> dueños = dueñoService.getDuenos();
		List<Empleado> empleados = empleadoService.getAll();
				
		m.addObject("mascotaList", resumenAtenciones);
		//m.addObject("mascotaList", mascotas);
		m.addObject("mascota", new Mascota());
		m.addObject("duenos", dueños);
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
		
		Dueño dueno = dueñoService.getByRut(rutDueno);
		List<Mascota> mascotas = mascotaService.getMascotas(dueno);
		m.addObject("duenos", dueñoService.getDuenos() );
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
			@ModelAttribute("rutDueño")String rutDueño,
			@ModelAttribute("rutEmpleado")String rutEmpleado,	
			@ModelAttribute("idMascota")String idMascota,				
			@ModelAttribute("selectMascota")String selectMascota
			){
		
		ModelAndView m = new ModelAndView("Informes/Mascota");
		
		Dueño dueño = dueñoService.getByRut(rutDueño);
		List<Mascota> mascotas = mascotaService.getMascotas(dueño);
		m.addObject("dueñoList", dueñoService.getDuenos());
		m.addObject("empleadoList", empleadoService.getAll());
		m.addObject("mascotaList", mascotas);
		m.addObject("rutDueño", rutDueño);
		m.addObject("rutEmpleado", rutEmpleado);
		m.addObject("idMascota", idMascota);
		
		if(selectMascota.equalsIgnoreCase("S")){

			return m;
		}

		m.addObject("resumenAtencionList", informeService.getByBusqueda(rutDueño, idMascota, rutEmpleado));
		
		return m;
	}
	*/
	
	/*
	@RequestMapping(value="/Mascota", method=RequestMethod.POST)
	public ModelAndView informePost(){
		ModelAndView m = new ModelAndView("Informes/Mascota");
			
		List<VwResumenAtencione> informes = informeService.getAll();
		List<Mascota> mascotas = mascotaService.getAll();
		List<Dueño> dueños = dueñoService.getDuenos();
		List<Empleado> empleados = empleadoService.getAll();
		
		m.addObject("informeList", informes);
		m.addObject("mascotaList", mascotas);
		m.addObject("dueñoList", dueños);
		m.addObject("empleadoList", empleados);
		
		return m;
	}
	*/
	
}