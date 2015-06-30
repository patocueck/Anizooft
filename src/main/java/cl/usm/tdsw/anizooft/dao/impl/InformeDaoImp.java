package cl.usm.tdsw.anizooft.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;
import cl.usm.tdsw.anizooft.dao.InformeDao;

@Repository
@Transactional
public class InformeDaoImp implements InformeDao {
	
	@PersistenceContext
    EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getAll() {
		return em.createNamedQuery("VwResumenAtencione.findAll").getResultList();
	}

	/*
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByIdMascota(long idMascota) {
		return em.createNamedQuery("VwResumenAtencione.findByIdMascota").setParameter("idmascota", idMascota).getResultList();
	}
	*/
}
