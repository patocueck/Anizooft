package cl.usm.tdsw.anizooft.dao;

import java.util.Date;
import java.util.List;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;

public interface InformeDao {
	public List<VwResumenAtencione> getAll();
	public List<VwResumenAtencione> getByIdMascota (long idMascota);
	public List<VwResumenAtencione> getByRutDue�o (long rutDue�o);
	public List<VwResumenAtencione> getByRutEmpleado (long rutEmpleado);
	public List<VwResumenAtencione> getByBusqueda(String rutDue�o, String idMascota, String rutEmpleado);
}