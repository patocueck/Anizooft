package cl.usm.tdsw.anizooft.service.imp;

import cl.usm.tdsw.anizooft.dao.DuenoDao;
import cl.usm.tdsw.anizooft.model.Due�o;
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
	public List<Due�o> getDuenos(){
		
		return duenoDao.getDuenos();
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public void add(Due�o dueno){
		duenoDao.add(dueno);
	}
	
	public Map<String, String> getRutFormateado(List<Due�o> duenos){
		Map<String,String> ret = new HashMap<String,String>();
		/*AnizooftUtils ani = new AnizooftUtils();
		for (Due�o dueno : duenos) {
			ret.put(Long.toString(dueno.getRutdue�o()), ani.formatRut(dueno.getRutdue�o()));
		}		*/
		return ret;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Due�o getByRut(String rut) {
		return duenoDao.getByRut(rut);
	}
}
