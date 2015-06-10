package cl.usm.tdsw.anizooft.service;

import java.util.List;
import cl.usm.tdsw.anizooft.model.Atencion;


public interface AtencionService {

		public List<Atencion> getAll();
		public Atencion getById(long idatencion);
		public void add(Atencion atencion);
		
}
