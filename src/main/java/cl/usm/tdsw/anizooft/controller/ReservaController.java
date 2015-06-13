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
import cl.usm.tdsw.anizooft.model.Reserva;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;
import cl.usm.tdsw.anizooft.service.ReservaService;

@Controller
@RequestMapping(value="/Reserva")
public class ReservaController {
	
	@Autowired
	private ReservaService reservaService;
	@Autowired
	private DuenoService duenoService;
	@Autowired
	private EmpleadoService empleadoService;

	
	//Se llama al cargar la pagina
	@RequestMapping(value="/Index", method=RequestMethod.GET)
	public ModelAndView indexGet(){
		ModelAndView m = new ModelAndView("Reserva/Index");
			
		List<Reserva> reservas = reservaService.getAll();		
		m.addObject("reservas", reservas);
		
		return m;
	}
	
	//Se llama al cargar el form de creacion
		@RequestMapping(value="/Create", method=RequestMethod.GET)
		public ModelAndView creatGet(){
			ModelAndView m = new ModelAndView("Reserva/Create");
			
			m.addObject("duenos", duenoService.getDuenos() );
			m.addObject("Reserva", new Reserva());
			return m;
		}
		
		//Se llama al presionar el boton guardar form.
		@RequestMapping(value="/Create", method=RequestMethod.POST)
		public ModelAndView creatPost(@ModelAttribute("reserva") Reserva reserva,
				@ModelAttribute("rutDueno")String rutDueno,				
				@ModelAttribute("ano")String ano,
				@ModelAttribute("mes")String mes,
				@ModelAttribute("dia")String dia,
				@ModelAttribute("hora")String hora
				){
			ModelAndView mensaje = new ModelAndView("Varios/Mensaje");
			ModelAndView m = new ModelAndView("Reserva/Create");
							
			
			//Agregar atencion
			int iAno = Integer.parseInt(ano);
			int iMes = Integer.parseInt(mes);iMes--;
			int iDia = Integer.parseInt(dia); 
			int iHor = Integer.parseInt(hora.split(":")[0]);
			int iMin = Integer.parseInt(hora.split(":")[1]);			
			Date horario = new Date(iAno,iMes,iDia,iHor,iMin);
			
			
			System.out.println("ano: " + iAno);
			System.out.println("mes: " + iMes);
			System.out.println("dia: " + iDia);
			System.out.println("hora: " + iHor);
			System.out.println("min: " + iMin);
			System.out.println("horarop: " + horario);
			
			Dueño dueno = duenoService.getByRut(rutDueno);			
			reserva.setDueño(dueno);			
			reserva.setFechahora(horario);
			
			reserva.setEstadoreserva("PENDIENTE");
						
			reservaService.add(reserva);
			mensaje.addObject("mensaje", "La Reserva " + reserva.getIdreserva() + " para el Rut: " + dueno.getRutdueño() + " fue agregada con éxito.");
			mensaje.addObject("urlRetorno","../Reserva/Index");
			return mensaje;			
		}
	
}
