package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the RECETA database table.
 * 
 */
@Entity
@NamedQuery(name="Receta.findAll", query="SELECT r FROM Receta r")
public class Receta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RECETA_IDRECETA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RECETA_IDRECETA_GENERATOR")
	private long idreceta;

	private String observacion;

	//bi-directional many-to-one association to Dosi
	@OneToMany(mappedBy="receta")
	private List<Dosi> dosis;

	//bi-directional many-to-one association to Atencion
	@ManyToOne
	@JoinColumn(name="IDATENCION")
	private Atencion atencion;

	public Receta() {
	}

	public long getIdreceta() {
		return this.idreceta;
	}

	public void setIdreceta(long idreceta) {
		this.idreceta = idreceta;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public List<Dosi> getDosis() {
		return this.dosis;
	}

	public void setDosis(List<Dosi> dosis) {
		this.dosis = dosis;
	}

	public Dosi addDosi(Dosi dosi) {
		getDosis().add(dosi);
		dosi.setReceta(this);

		return dosi;
	}

	public Dosi removeDosi(Dosi dosi) {
		getDosis().remove(dosi);
		dosi.setReceta(null);

		return dosi;
	}

	public Atencion getAtencion() {
		return this.atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

}