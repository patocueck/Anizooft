package cl.usm.tdsw.anizooft.dao;

import java.util.List;

import cl.usm.tdsw.anizooft.model.Atencion;

public interface AtencionDao {

	public List<Atencion> getAll();
	public Atencion getById(long idatencion);
	public void add(Atencion atencion);
}
