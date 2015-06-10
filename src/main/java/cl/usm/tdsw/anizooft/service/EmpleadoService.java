package cl.usm.tdsw.anizooft.service;

import java.util.List;

import cl.usm.tdsw.anizooft.model.Empleado;

public interface EmpleadoService {

	public List<Empleado> getAll();
	public Empleado getByRut(long rut);	
}
