package cl.usm.tdsw.anizooft.service;

import cl.usm.tdsw.anizooft.model.Due�o;

import java.util.*;


public interface DuenoService {


	public List<Due�o> getDuenos();
	public Map<String, String> getRutFormateado(List<Due�o> duenos);
	public void add(Due�o dueno);
	public Due�o getByRut(String rut);
}
