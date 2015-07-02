package cl.usm.tdsw.anizooft.service;

import java.util.Date;
import java.util.List;

import cl.usm.tdsw.anizooft.model.VwHistorial;

public interface HistorialService {

	public List<VwHistorial> getByBusqueda(String rutDueno, String idMascota,
			String veterinario, Date fechaInicio, Date fechaFin);
}
