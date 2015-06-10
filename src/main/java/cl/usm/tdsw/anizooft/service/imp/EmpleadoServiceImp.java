package cl.usm.tdsw.anizooft.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.EmpleadoDao;
import cl.usm.tdsw.anizooft.model.Empleado;
import cl.usm.tdsw.anizooft.service.EmpleadoService;

@Service
public class EmpleadoServiceImp implements EmpleadoService {

	@Autowired
	private EmpleadoDao empleadoDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Empleado> getAll() {
		return empleadoDao.getAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Empleado getByRut(long rut) {
		
		return empleadoDao.getByRut(rut);
	}

}
