package cl.usm.tdsw.anizooft.dao;

import java.util.Date;
import java.util.List;

import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.model.VwHistorial;

public interface HistorialDao {

	public List<VwHistorial> getByBusqueda(String rutDueno, String idMascota, String veterinario, Date fechaInicio, Date fechaFin) ;
}
