package cl.usm.tdsw.anizooft.service;

import java.util.Date;
import java.util.List;

import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;

public interface MascotaService {

	public Mascota getByRutByNombre(String rut, String nombre);
	public List<Mascota> getMascotas(Dueño dueno);
	public void add(Mascota mascota);
	public List<Mascota> getAll();
	public Mascota getById(long idMascota);
	public List<Mascota> getByBusqueda(String rutDueno, String idMascota, String veterinario, Date fechaInicio, Date fechaFin);
	
}
