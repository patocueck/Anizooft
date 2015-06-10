package cl.usm.tdsw.anizooft.service.imp;

import cl.usm.tdsw.anizooft.dao.DuenoDao;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.service.DuenoService;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
//@Transactional
public class DuenoServiceImp implements DuenoService{

	@Autowired
	private DuenoDao duenoDao;
	 
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Dueño> getDuenos(){
		
		return duenoDao.getDuenos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Dueño dueno){
		duenoDao.add(dueno);
	}
	
	public Map<String, String> getRutFormateado(List<Dueño> duenos){
		Map<String,String> ret = new HashMap<String,String>();
		/*AnizooftUtils ani = new AnizooftUtils();
		for (Dueño dueno : duenos) {
			ret.put(Long.toString(dueno.getRutdueño()), ani.formatRut(dueno.getRutdueño()));
		}		*/
		return ret;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Dueño getByRut(String rut) {
		return duenoDao.getByRut(rut);
	}
}
