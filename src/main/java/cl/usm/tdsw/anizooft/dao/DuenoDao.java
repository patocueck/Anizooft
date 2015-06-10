package cl.usm.tdsw.anizooft.dao;

import cl.usm.tdsw.anizooft.model.*;

import java.util.*;

public interface DuenoDao {
	
	public List<Dueño> getDuenos();

	public void add(Dueño dueno);

	public Dueño getByRut(String rut);
}
