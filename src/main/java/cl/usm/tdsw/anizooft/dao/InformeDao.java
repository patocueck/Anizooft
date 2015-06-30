package cl.usm.tdsw.anizooft.dao;

import java.util.List;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;

public interface InformeDao {
	public List<VwResumenAtencione> getAll();
	//public List<VwResumenAtencione> getByIdMascota (long idMascota);
}