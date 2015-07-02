package cl.usm.tdsw.anizooft.service.imp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.DuenoDao;
import cl.usm.tdsw.anizooft.dao.MascotaDao;
import cl.usm.tdsw.anizooft.model.Atencion;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;
import cl.usm.tdsw.anizooft.service.MascotaService;

@Service
public class MascotaServiceImp implements MascotaService {
	
	@Autowired
	private MascotaDao mascotaDao;
	
	@Autowired
	private DuenoDao duenoDao;
	
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
	public List<Mascota> getAll() {
		return mascotaDao.getAll();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mascota getById(long idMascota) {
		return mascotaDao.getById(idMascota);
	}

	@Override
	public List<Mascota> getByBusqueda(String rutDueno, String idMascota,
			String veterinario, Date fechaInicio, Date fechaFin) {
		
		
		System.out.println("-----" + rutDueno + "-" + idMascota + "-" + veterinario + "-" +  fechaInicio.toLocaleString() + " / " +  fechaFin.toLocaleString());
		
		List<Mascota> mascotas = mascotaDao.getByBusqueda(rutDueno, idMascota, veterinario, fechaInicio, fechaFin);
		List<Mascota> filtradas = new ArrayList<Mascota>();
		
		for (Mascota mascota : mascotas) {
			for (Atencion atencion : mascota.getAtencions()) {
				Date fecha = atencion.getFechahora();
				if ( fecha.after(fechaInicio) && fecha.before(fechaFin)){
					System.out.println("La fecha de la BD es mayor");
				}
			}
		}
		
		return mascotas;
	}

}
