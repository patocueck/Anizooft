package cl.usm.tdsw.anizooft.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByIdMascota(long idMascota) {
		return em.createNamedQuery("VwResumenAtencione.findByIdMascota").setParameter("idmascota", idMascota).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByRutDueño(long rutDueño) {
		return em.createNamedQuery("VwResumenAtencione.findByRutDueño").setParameter("rutdueño", rutDueño).getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByRutEmpleado(long rutEmpleado) {
		return em.createNamedQuery("VwResumenAtencione.findByRutEmpleado").setParameter("rutempleado", rutEmpleado).getResultList();
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwResumenAtencione> getByBusqueda(String rutDueño,String idMascota,String rutEmpleado) {

		Map<String,Object> params=new HashMap<String, Object>();       
		
		List<VwResumenAtencione> resumenAtenciones = null;
		//String query = "select v from Mascota v, IN (v.atencions) at where ";
		String query = "select  v from VwResumenAtencione v ";
        String condicion="";
        
        if( !rutDueño.isEmpty() && !rutDueño.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
            condicion+="v.rutdueño = :rutdueño";
            params.put("rutdueño", rutDueño);
        }
        
        if( !idMascota.isEmpty() && !idMascota.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
            condicion+="v.idmascota = :idmascota";
            Long idMascotaLong = Long.parseLong(idMascota);
            params.put("idmascota", idMascotaLong );
        }
        
        if( !rutEmpleado.isEmpty() && !rutEmpleado.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
           // tablas+=", IN(v.atencions) at, IN (at.empleados) emp  ";
            condicion+="v.rutempleado = :rutempleado";
            Long rutEmpleadoLong = Long.parseLong(rutEmpleado);
            params.put("rutempleado", rutEmpleadoLong);
        }


        
//        if(!condicion.isEmpty()){ condicion+=" and "; }
//        condicion+=" v.fechahora <= :fechaFin";
//        condicion+=" and v.fechahora >= :fechaInicio";
//        params.put("fechaFin", fechaFin);
//        params.put("fechaInicio", fechaInicio);
        
        
        
        if (!condicion.isEmpty() && !condicion.equals("") )
        	condicion = " where " + condicion;
        Query qry=em.createQuery(query + condicion);
        
        
        for(String k : params.keySet()){
            qry.setParameter(k, params.get(k));
            System.out.println("parametros: " + params.get(k) );
        }
                

        resumenAtenciones = qry.getResultList();
        System.out.println("Atenciones" + resumenAtenciones);
        return resumenAtenciones;
	}
		
}
