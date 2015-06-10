package cl.usm.tdsw.anizooft.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.AtencionDao;
import cl.usm.tdsw.anizooft.model.Atencion;

@Repository
@Transactional
public class AtencionDaoImp implements AtencionDao {

	@PersistenceContext
    EntityManager em;
	
	@Override
	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Atencion> getAll() {
		return  em.createNamedQuery("Atencion.findAll").getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Atencion getById(long idatencion) {
		return em.find(Atencion.class, idatencion);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Atencion atencion) {
		em.persist(atencion);		
	}

}
