package cl.usm.tdsw.anizooft.service.imp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.AtencionDao;
import cl.usm.tdsw.anizooft.dao.EmpleadoDao;
import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.model.Empleado;
import cl.usm.tdsw.anizooft.service.AtencionService;

@Service
public class AtencionServiceImp implements AtencionService {

	@Autowired
	private AtencionDao atencionDao;
	@Autowired
	private EmpleadoDao empleadoDao;
	
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

	@Override
	public boolean update(Atencion atencion) {
		try{
			atencionDao.update(atencion);
			return true;
		}catch(Exception e){
			return false;
		}	
		
	}

	@Override
	public Atencion MergeAtencion(Atencion atencion) {
		//Trae atención original
		Atencion atencionOriginal = getById(atencion.getIdatencion());
		
		atencion.setEmpleados(atencionOriginal.getEmpleados()); //Empleados - Veterinarios
		atencion.setMascota(atencionOriginal.getMascota()); //Mascota
		atencion.setFechahora(atencionOriginal.getFechahora()); //Fecha Hora
		atencion.setSala(atencionOriginal.getSala()); //Sala
		return atencion;
	}

}
