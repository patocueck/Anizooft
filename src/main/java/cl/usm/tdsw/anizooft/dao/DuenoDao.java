package cl.usm.tdsw.anizooft.dao;

import cl.usm.tdsw.anizooft.model.*;

import java.util.*;

public interface DuenoDao {
	
	public List<Due�o> getDuenos();

	public void add(Due�o dueno);

	public Due�o getByRut(String rut);
}
