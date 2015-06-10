package cl.usm.tdsw.anizooft.dao;

import java.util.List;



import cl.usm.tdsw.anizooft.model.Due�o;
import cl.usm.tdsw.anizooft.model.Mascota;

public interface MascotaDao {
	public List<Mascota> getMascotas(Due�o dueno);

	
	public void add(Mascota mascota);
	public List<Mascota> getAll();
	public Mascota getById(long idMascota);
}
