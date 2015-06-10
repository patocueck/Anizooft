package cl.usm.tdsw.anizooft.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.MascotaDao;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;

@Repository
@Transactional
public class MascotaDaoImp implements MascotaDao {
	
	@PersistenceContext
    EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Mascota> getMascotas(Dueño dueno) {
		return em.createNamedQuery("Mascota.findByDueño").setParameter("dueño", dueno).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Mascota mascota) {
		em.persist(mascota);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Mascota> getAll() {
		return em.createNamedQuery("Mascota.findAll").getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mascota getById(long idMascota) {
		return em.find(Mascota.class, idMascota);
	}

}
