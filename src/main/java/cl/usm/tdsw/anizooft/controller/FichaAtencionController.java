package cl.usm.tdsw.anizooft.controller;

import java.util.ArrayList;
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
import cl.usm.tdsw.anizooft.model.Empleado;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.service.AtencionService;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;
import cl.usm.tdsw.anizooft.service.MascotaService;


@Controller
@RequestMapping(value="/FichaAtencion")
public class FichaAtencionController {

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
		ModelAndView m = new ModelAndView("FichaAtencion/Index");
			
		List<Atencion> fichas = atencionService.getAll();		
		m.addObject("fichas", fichas);
		
		return m;
	}
	
	//Se llama al cargar el form de creacion
		@RequestMapping(value="/Create", method=RequestMethod.GET)
		public ModelAndView creatGet(){
			ModelAndView m = new ModelAndView("FichaAtencion/Create");
			
			m.addObject("duenos", duenoService.getDuenos() );
			m.addObject("empleados", empleadoService.getAll());
			m.addObject("ficha", new Atencion());
			return m;
		}
		
		//Se llama al presionar el boton guardar form.
		@RequestMapping(value="/Create", method=RequestMethod.POST)
		public ModelAndView creatPost(@ModelAttribute("atencion") Atencion atencion,
				@ModelAttribute("rutDueno")String rutDueno,
				@ModelAttribute("rutEmpleado")String rutEmpleado,	
				@ModelAttribute("idMascota")String idMascota,				
				@ModelAttribute("ano")String ano,
				@ModelAttribute("mes")String mes,
				@ModelAttribute("dia")String dia,
				@ModelAttribute("hora")String hora,
				@ModelAttribute("selectMascota")String selectMascota
				){
			ModelAndView mensaje = new ModelAndView("Varios/Mensaje");
			ModelAndView m = new ModelAndView("FichaAtencion/Create");
			
			
			if(selectMascota.equalsIgnoreCase("S")){
				Dueño dueno = duenoService.getByRut(rutDueno);
				List<Mascota> mascotas = mascotaService.getMascotas(dueno);
				m.addObject("duenos", duenoService.getDuenos() );
				m.addObject("empleados", empleadoService.getAll());
				m.addObject("mascotas", mascotas);
				m.addObject("rutDueno", rutDueno);
				m.addObject("rutEmpleado", rutEmpleado);
				m.addObject("idMascota", idMascota);
				m.addObject("ano", ano);
				m.addObject("mes", mes);
				m.addObject("dia", dia);
				m.addObject("hora", hora);
				return m;
			}
				
			
			//Agregar atencion
			int iAno = Integer.parseInt(ano);
			int iMes = Integer.parseInt(mes);
			int iDia = Integer.parseInt(dia);
			int iHor = Integer.parseInt(hora.split(":")[0]);
			int iMin = Integer.parseInt(hora.split(":")[1]);			
			Date horario = new Date(iAno,iMes,iDia,iHor,iMin);
			
			atencion.setFechahora(horario);
			atencion.setMascota(mascotaService.getById(Long.parseLong(idMascota)));
			List<Empleado> empleados = new ArrayList<Empleado>();
			empleados.add(empleadoService.getByRut(Long.parseLong(rutEmpleado)));
			atencion.setEmpleados(empleados);
			atencion.setEstadoatencion("PENDIENTE");
			atencion.setObservacion(hora);
			//atencion.setSala(sala);
			
			atencionService.add(atencion);
			mensaje.addObject("mensaje", "Atención agregada con éxito.");
			mensaje.addObject("urlRetorno","../FichaAtencion/Index");
			return mensaje;
			
			
		}
}
