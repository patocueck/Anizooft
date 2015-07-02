package cl.usm.tdsw.anizooft.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TemporalType;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import cl.usm.tdsw.anizooft.dao.MascotaDao;
import cl.usm.tdsw.anizooft.model.Dueño;
import cl.usm.tdsw.anizooft.model.Mascota;

@Repository
@Transactional
public class MascotaDaoImp implements MascotaDao {
	
	@PersistenceContext
    EntityManager em;

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Mascota> getMascotas(Dueño dueno) {
		return em.createNamedQuery("Mascota.findByDueño").setParameter("dueño", dueno).getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void add(Mascota mascota) {
		em.persist(mascota);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<Mascota> getAll() {
		return em.createNamedQuery("Mascota.findAll").getResultList();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public Mascota getById(long idMascota) {
		return em.find(Mascota.class, idMascota);
	}

	@Override
	public List<Mascota> getByBusqueda(String rutDueno, String idMascota,
		String veterinario, Date fechaInicio, Date fechaFin) {
		Map<String,Object> params=new HashMap<String, Object>();
        
		
		List<Mascota> mascotas = null;
		//String query = "select v from Mascota v, IN (v.atencions) at where ";
		String query = "select  v from Mascota v, IN(v.atencions) at, IN (at.empleados) emp ";
        String condicion="";
        String tablas="";
        
        if( !rutDueno.isEmpty() && !rutDueno.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
            condicion+="v.dueño.rutdueño = :rutdueno";
            params.put("rutdueno", rutDueno );
        }
        
        if( !idMascota.isEmpty() && !idMascota.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
            condicion+="v.idmascota = :idMascota";
            Long idMascotaLong = Long.parseLong(idMascota);
            params.put("idMascota", idMascotaLong );
        }
        
        if( !veterinario.isEmpty() && !veterinario.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
           // tablas+=", IN(v.atencions) at, IN (at.empleados) emp  ";
            condicion+="emp.rutempleado = :idVeterinario";
            Long idVeterinario = Long.parseLong(veterinario);
            params.put("idVeterinario", idVeterinario );
        }

        //if(!condicion.isEmpty()){ condicion+=" and "; }
        //condicion+=" at.fechahora <= :fechaFin";
        //condicion+=" and at.fechahora >= :fechaInicio";
        //condicion+=" (at.fechahora BETWEEN :fechaInicio and :fechaFin ) ";
        
//        if(!condicion.isEmpty()){ condicion+=" and "; }
//        condicion+=" at.fechahora <= :fechaFin";
//        condicion+=" and at.fechahora >= :fechaInicio";
//        params.put("fechaFin", fechaFin);
//        params.put("fechaInicio", fechaInicio);
        
        
        
        if (!condicion.isEmpty() && !condicion.equals("") )
        	condicion = " where " + condicion;
        Query qry=em.createQuery(query+ tablas + condicion);
        
        
        for(String k : params.keySet()){
            qry.setParameter(k, params.get(k));
            System.out.println("parametros: " + params.get(k) );
        }
        
        
        //qry.setParameter("fechaFin", fechaFin, TemporalType.DATE);
        //qry.setParameter("fechaInicio", fechaInicio, TemporalType.DATE);
        

        mascotas = qry.getResultList();
        System.out.println("Mascotas" + mascotas);
        return mascotas;
	}

}
