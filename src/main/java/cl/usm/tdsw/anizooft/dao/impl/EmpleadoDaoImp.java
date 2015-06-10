package cl.usm.tdsw.anizooft.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.EmpleadoDao;
import cl.usm.tdsw.anizooft.model.Empleado;

@Repository
@Transactional
public class EmpleadoDaoImp implements EmpleadoDao {

	@PersistenceContext
    EntityManager em;
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Empleado> getAll() {
		return em.createNamedQuery("Empleado.findAll").getResultList(); 
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Empleado getByRut(long rut) {
		return em.find(Empleado.class, rut);
	}

}
