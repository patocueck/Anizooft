package cl.usm.tdsw.anizooft.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.service.AtencionService;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;
import cl.usm.tdsw.anizooft.service.MascotaService;

@Controller
@RequestMapping(value="/Mascota")
public class MascotaController {
	
	@Autowired
	private AtencionService atencionService;
	
	@Autowired
	private DuenoService duenoService;
	
	@Autowired
	private MascotaService mascotaService;

	@Autowired
	private EmpleadoService empleadoService;

	//Se llama al cargar la pagina
	@RequestMapping(value="/Index", method=RequestMethod.GET)
	public ModelAndView indexGet(){
		ModelAndView m = new ModelAndView("Mascota/Index");
			
		List<Mascota> mascotas = mascotaService.getAll();
		
		m.addObject("mascotas", mascotas);
		
		return m;
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Create", method=RequestMethod.GET)
	public ModelAndView creatGet(){
		ModelAndView m = new ModelAndView("Mascota/Create");
		
		m.addObject("duenos", duenoService.getDuenos() );
		m.addObject("mascota", new Mascota());
		return m;
	}
	
	//Se llama al presionar el boton guardar form.
	@RequestMapping(value="/Create", method=RequestMethod.POST)
	public ModelAndView creatPost(@ModelAttribute("mascota") Mascota mascota,
			@ModelAttribute("rutDueno")String rutDueno,
			@ModelAttribute("ano")String ano,
			@ModelAttribute("mes")String mes,
			@ModelAttribute("dia")String dia
			){
		ModelAndView mensaje = new ModelAndView("Varios/Mensaje");
		
		
		//Valida si existe
		Mascota valMasc = mascotaService.getByRutByNombre(rutDueno, mascota.getNombre()) ;
		if (valMasc != null){
			mensaje.addObject("mensaje", "La mascota ya existe para el dueño: " + rutDueno );
			return mensaje;
		}
		
		//Agregar dueño
		mascota.setDueño(duenoService.getByRut(rutDueno));
		int iAno = Integer.parseInt(ano);
		int iMes = Integer.parseInt(mes);
		int iDia = Integer.parseInt(dia);
		Date nacimiento = new Date(iAno,iMes,iDia);
		mascota.setNacimiento(nacimiento);
		mascotaService.add(mascota);
		mensaje.addObject("mensaje", "Mascota agregada con éxito.");
		mensaje.addObject("urlRetorno","../Mascota/Index");
		return mensaje;
		
		
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Historial", method=RequestMethod.GET)
	public ModelAndView historialGet(){
		ModelAndView m = new ModelAndView("Mascota/Historial");
		
		m.addObject("duenos", duenoService.getDuenos() );
		m.addObject("mascota", new Mascota());
		return m;
	}
	
	//Se llama al cargar el form de creacion
	@RequestMapping(value="/Historial", method=RequestMethod.POST)
	public ModelAndView historialPost(@ModelAttribute("mascota") Mascota mascota,
			@ModelAttribute("rutDueno")String rutDueno,
			@ModelAttribute("rutEmpleado")String rutEmpleado,	
			@ModelAttribute("idMascota")String idMascota,				
			@ModelAttribute("ano")String ano,
			@ModelAttribute("mes")String mes,
			@ModelAttribute("dia")String dia
						
			){
		ModelAndView m = new ModelAndView("Mascota/Historial");
		
		m.addObject("duenos", duenoService.getDuenos() );
		m.addObject("mascota", new Mascota());
		return m;
	}
}
