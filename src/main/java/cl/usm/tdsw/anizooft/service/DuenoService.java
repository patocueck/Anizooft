package cl.usm.tdsw.anizooft.service;

import cl.usm.tdsw.anizooft.model.Dueño;

import java.util.*;


public interface DuenoService {


	public List<Dueño> getDuenos();
	public Map<String, String> getRutFormateado(List<Dueño> duenos);
	public void add(Dueño dueno);
	public Dueño getByRut(String rut);
}
