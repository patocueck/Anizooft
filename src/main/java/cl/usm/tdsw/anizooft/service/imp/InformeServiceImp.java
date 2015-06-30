package cl.usm.tdsw.anizooft.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.model.VwResumenAtencione;
import cl.usm.tdsw.anizooft.dao.InformeDao;
import cl.usm.tdsw.anizooft.service.InformeService;

@Service
public class InformeServiceImp implements InformeService {
	
	@Autowired
	private InformeDao InformeDao;
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getAll() {
		return InformeDao.getAll();
	}
	
	/*
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByIdMascota(long idMascota) {
		return InformeDao.getByIdMascota(idMascota);
	}
	*/
	
	/*
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Mascota> getMascotas(Dueño dueno) {
		return mascotaDao.getMascotas(dueno);

	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Mascota mascota) {
		mascotaDao.add(mascota);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mascota getByRutByNombre(String rut, String nombre){
		Mascota ret ;
		Dueño dueno = duenoDao.getByRut(rut);
		List<Mascota> lista = new ArrayList<Mascota>();
		if (dueno != null){
			lista = getMascotas(dueno); 
		}
		
		for (Mascota mascota : lista) {
			if (mascota.getNombre().equalsIgnoreCase(nombre))
				return mascota;
		}
		
		return null;
	}
	*/
}