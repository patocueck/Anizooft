package cl.usm.tdsw.anizooft.service.imp;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;
import cl.usm.tdsw.anizooft.dao.InformeDao;
import cl.usm.tdsw.anizooft.service.InformeService;

@Service
public class InformeServiceImp implements InformeService {
	
	@Autowired
	private InformeDao InformeDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getAll() {
		return InformeDao.getAll();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByIdMascota(long idMascota) {
		return InformeDao.getByIdMascota(idMascota);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByRutDueño(long rutDueño) {
		return InformeDao.getByRutDueño(rutDueño);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByRutEmpleado(long rutEmpleado) {
		return InformeDao.getByRutEmpleado(rutEmpleado);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByBusqueda(String rutDueño, String idMascota,String rutEmpleado) {
		
		System.out.println("-----" + rutDueño + "-" + idMascota + "-" + rutEmpleado);
		
		List<VwResumenAtencione> resumenAtenciones = InformeDao.getByBusqueda(rutDueño, idMascota, rutEmpleado);
//		List<VwResumenAtencione> filtradas = new ArrayList<VwResumenAtencione>();
//		
//		for (Mascota mascota : mascotas) {
//			for (Atencion atencion : mascota.getAtencions()) {
//				Date fecha = atencion.getFechahora();
//				if ( fecha.after(fechaInicio) && fecha.before(fechaFin)){
//					System.out.println("La fecha de la BD es mayor");
//				}
//			}
//		}
		
		return resumenAtenciones;

	}
	
}