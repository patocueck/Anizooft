package cl.usm.tdsw.anizooft.service;

//import java.util.Date;
import java.util.List;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;

public interface InformeService {

	public List<VwResumenAtencione> getAll();
	public List<VwResumenAtencione> getByIdMascota(long idMascota);
	public List<VwResumenAtencione> getByRutDueño(long rutDueño);
	public List<VwResumenAtencione> getByRutEmpleado(long rutEmpleado);
	
	public List<VwResumenAtencione> getByBusqueda(String rutDueño, String idMascota,String rutEmpleado);
	
}