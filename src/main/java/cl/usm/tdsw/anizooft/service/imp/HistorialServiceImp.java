package cl.usm.tdsw.anizooft.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.HistorialDao;
import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.model.VwHistorial;
import cl.usm.tdsw.anizooft.service.HistorialService;

@Repository
public class HistorialServiceImp implements HistorialService {

	@Autowired
	private HistorialDao historialDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwHistorial> getByBusqueda(String rutDueno, String idMascota,
			String veterinario, Date fechaInicio, Date fechaFin) {
		
		System.out.println("-----" + rutDueno + "-" + idMascota + "-" + veterinario + "-" +  fechaInicio.toLocaleString() + " / " +  fechaFin.toLocaleString());
		
		List<VwHistorial> mascotas = historialDao.getByBusqueda(rutDueno, idMascota, veterinario, fechaInicio, fechaFin);
//		List<VwHistorial> filtradas = new ArrayList<VwHistorial>();
//		
//		for (Mascota mascota : mascotas) {
//			for (Atencion atencion : mascota.getAtencions()) {
//				Date fecha = atencion.getFechahora();
//				if ( fecha.after(fechaInicio) && fecha.before(fechaFin)){
//					System.out.println("La fecha de la BD es mayor");
//				}
//			}
//		}
		
		return mascotas;

	}

}
