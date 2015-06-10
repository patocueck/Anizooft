package cl.usm.tdsw.anizooft.dao;

import java.util.List;

import cl.usm.tdsw.anizooft.model.Empleado;

public interface EmpleadoDao {

	public List<Empleado> getAll();
	public Empleado getByRut(long rut);	
}
