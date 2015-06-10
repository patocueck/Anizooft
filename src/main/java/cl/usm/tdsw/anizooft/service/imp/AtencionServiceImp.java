package cl.usm.tdsw.anizooft.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.AtencionDao;
import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.service.AtencionService;

@Service
public class AtencionServiceImp implements AtencionService {

	@Autowired
	private AtencionDao atencionDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Atencion> getAll() {
		List<Atencion> lista = new ArrayList<Atencion>();
		lista = atencionDao.getAll();
		return lista;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Atencion getById(long idatencion) {
//		Atencion atencion = new Atencion();
//		atencion = atencionDao.getById(idatencion);
		return atencionDao.getById(idatencion);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Atencion atencion) {
		atencionDao.add(atencion);		
	}

}