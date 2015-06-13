package cl.usm.tdsw.anizooft.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.usm.tdsw.anizooft.dao.ReservaDao;
import cl.usm.tdsw.anizooft.model.Reserva;
import cl.usm.tdsw.anizooft.service.ReservaService;

@Service
public class ReservaServiceImp implements ReservaService {

	@Autowired
	private ReservaDao reservaDao;
	
	@Override
	public Reserva getById(long id) {
		return reservaDao.getById(id);
	}

	@Override
	public List<Reserva> getAll() {
		return reservaDao.getAll();
	}

	@Override
	public void add(Reserva reserva) {
		reservaDao.add(reserva);
	}

}
