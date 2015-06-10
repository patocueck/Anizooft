package cl.usm.tdsw.anizooft.dao.impl;


import cl.usm.tdsw.anizooft.dao.DuenoDao;
import cl.usm.tdsw.anizooft.model.*;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;





import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public class DuenoDaoImpl implements DuenoDao {
	
	@PersistenceContext
    EntityManager em;
	

	@SuppressWarnings("unchecked")
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Dueño> getDuenos(){
		return  em.createNamedQuery("Dueño.findAll").getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Dueño dueno) {
		em.persist(dueno);
	}


	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Dueño getByRut(String rut) {
		return em.find(Dueño.class, rut);
		
	}
}
