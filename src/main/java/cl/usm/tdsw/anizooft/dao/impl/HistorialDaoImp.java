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

import cl.usm.tdsw.anizooft.dao.HistorialDao;
import cl.usm.tdsw.anizooft.model.VwHistorial;

@Repository
@Transactional
public class HistorialDaoImp implements HistorialDao {

	@PersistenceContext
    EntityManager em;
	
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<VwHistorial> getByBusqueda(String rutDueno, String idMascota,
			String veterinario, Date fechaInicio, Date fechaFin) {
Map<String,Object> params=new HashMap<String, Object>();
        
		
		List<VwHistorial> mascotas = null;
		//String query = "select v from Mascota v, IN (v.atencions) at where ";
		String query = "select  v from VwHistorial v ";
        String condicion="";
        
        if( !rutDueno.isEmpty() && !rutDueno.equals("")){
            if(!condicion.isEmpty()){ condicion+=" and "; }
            condicion+="v.rutdueño = :rutdueno";
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
            condicion+="v.rutEmpleado = :idVeterinario";
            Long idVeterinario = Long.parseLong(veterinario);
            params.put("idVeterinario", idVeterinario );
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
                

        mascotas = qry.getResultList();
        System.out.println("Mascotas" + mascotas);
        return mascotas;
	}

}
