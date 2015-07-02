package cl.usm.tdsw.anizooft.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import cl.usm.tdsw.anizooft.dao.MascotaDao;
import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.service.AtencionService;
import cl.usm.tdsw.anizooft.service.DuenoService;
import cl.usm.tdsw.anizooft.service.EmpleadoService;
import cl.usm.tdsw.anizooft.service.HistorialService;
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
	@Autowired
	private HistorialService historialService;

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
	
	//Se llama al form de Historial desde el Index
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
			@ModelAttribute("anoIni")String anoIni,
			@ModelAttribute("mesIni")String mesIni,
			@ModelAttribute("diaIni")String diaIni,				
			@ModelAttribute("anoFin")String anoFin,
			@ModelAttribute("mesFin")String mesFin,
			@ModelAttribute("diaFin")String diaFin,
			@ModelAttribute("selectMascota")String selectMascota
	//		@ModelAttribute("hBuscar")String hBuscar //Trae el valor del hidden del botón buscar

			){
		ModelAndView m = new ModelAndView("Mascota/Historial");
		
		Dueño dueno = duenoService.getByRut(rutDueno);
		List<Mascota> mascotas = mascotaService.getMascotas(dueno);
		m.addObject("duenos", duenoService.getDuenos() );
		m.addObject("empleados", empleadoService.getAll());
		m.addObject("mascotas", mascotas);
		m.addObject("rutDueno", rutDueno);
		m.addObject("rutEmpleado", rutEmpleado);
		m.addObject("idMascota", idMascota);
		m.addObject("anoIni", anoIni);
		m.addObject("mesIni", mesIni);
		m.addObject("diaIni", diaIni);
		m.addObject("anoFin", anoFin);
		m.addObject("mesFin", mesFin);
		m.addObject("diaFin", diaFin);
		
		if(selectMascota.equalsIgnoreCase("S")){

			return m;
		}

		
		
		Integer iAnoIni = Integer.parseInt(anoIni);
		Integer iMesIni = Integer.parseInt(mesIni);
		Integer iDiaIni = Integer.parseInt(diaIni);
		
		Integer iAnoFin = Integer.parseInt(anoFin);
		Integer iMesFin = Integer.parseInt(mesFin);
		Integer iDiaFin = Integer.parseInt(diaFin);
		
		/*Date fechaInicio = new Date(iAnoIni,iMesIni,iDiaIni);
		Date fechaFin = new Date(iAnoFin,iMesFin,iDiaFin);
		fechaInicio.setYear(iAnoIni - 1900);
		fechaFin.setYear(iAnoFin - 1900);
		fechaInicio.setMonth(iMesIni - 1);
		fechaFin.setMonth(iMesFin - 1);*/

		String sFechaIni = iDiaIni.toString() +"/"+ iMesIni.toString() + "/" + iAnoIni.toString();
		String sFechaFin = diaFin.toString() +"/"+ mesFin.toString() + "/" + anoFin.toString();
		
		
		Calendar cal = Calendar.getInstance();
		//String input = String.valueOf(inputDate);
		cal.set(Calendar.YEAR, iAnoIni);
		cal.set(Calendar.MONTH, iMesIni -1);
		cal.set(Calendar.DAY_OF_MONTH, iDiaIni);
		cal.set(Calendar.HOUR, 00);
        cal.set(Calendar.MINUTE,00);
        cal.set(Calendar.SECOND,00);
		Date fechaInicio = cal.getTime();
		
		Calendar cal2 = Calendar.getInstance();
		//String input = String.valueOf(inputDate);
		cal2.set(Calendar.YEAR, iAnoFin);
		cal2.set(Calendar.MONTH, iMesFin - 1);
		cal2.set(Calendar.DAY_OF_MONTH, iDiaFin);
		cal2.set(Calendar.HOUR, 23);
        cal2.set(Calendar.MINUTE,59);
        cal2.set(Calendar.SECOND,59);
		Date fechaFin = cal2.getTime();
		
		
//		SimpleDateFormat originalFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
//		Date fechaInicio = Date.from(Instant.now());
//		Date fechaFin= Date.from(Instant.now());
//		try {
//			fechaInicio = originalFormat.parse(sFechaIni);
//			fechaFin = originalFormat.parse(sFechaFin);
//		} catch (ParseException e) {
//			System.out.println("Error parseando");
//			e.printStackTrace();
//		}
		
		
		m.addObject("mascotaList", historialService.getByBusqueda(rutDueno, idMascota, rutEmpleado, fechaInicio, fechaFin));
		
		return m;
	}
}
