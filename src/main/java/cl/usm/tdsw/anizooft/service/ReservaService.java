package cl.usm.tdsw.anizooft.service;

import java.util.List;

import cl.usm.tdsw.anizooft.model.Reserva;

public interface ReservaService {

	public Reserva getById(long id);
	public List<Reserva> getAll();
	public void add(Reserva reserva);
	
}
