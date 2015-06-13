package cl.usm.tdsw.anizooft.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.ReservaDao;
import cl.usm.tdsw.anizooft.model.Reserva;

@Repository
@Transactional
public class ReservaDaoImp implements ReservaDao {

	@PersistenceContext
    EntityManager em;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Reserva getById(long id) {
		return em.find(Reserva.class, id);
	}

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Reserva> getAll() {
		return em.createNamedQuery("Reserva.findAll").getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Reserva reserva) {
		em.persist(reserva);
	}

}
