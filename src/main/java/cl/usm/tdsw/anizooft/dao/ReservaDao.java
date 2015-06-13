package cl.usm.tdsw.anizooft.dao;

import java.util.List;

import cl.usm.tdsw.anizooft.model.Reserva;

public interface ReservaDao {

	public Reserva getById(long id);
	public List<Reserva> getAll();
	public void add(Reserva reserva);

}
