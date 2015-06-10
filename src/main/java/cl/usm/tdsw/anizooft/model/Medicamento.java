package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the MEDICAMENTO database table.
 * 
 */
@Entity
@NamedQuery(name="Medicamento.findAll", query="SELECT m FROM Medicamento m")
public class Medicamento implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MEDICAMENTO_IDMEDICAMENTO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MEDICAMENTO_IDMEDICAMENTO_GENERATOR")
	private long idmedicamento;

	private String nombre;

	//bi-directional many-to-one association to Dosi
	@OneToMany(mappedBy="medicamento")
	private List<Dosi> dosis;

	public Medicamento() {
	}

	public long getIdmedicamento() {
		return this.idmedicamento;
	}

	public void setIdmedicamento(long idmedicamento) {
		this.idmedicamento = idmedicamento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Dosi> getDosis() {
		return this.dosis;
	}

	public void setDosis(List<Dosi> dosis) {
		this.dosis = dosis;
	}

	public Dosi addDosi(Dosi dosi) {
		getDosis().add(dosi);
		dosi.setMedicamento(this);

		return dosi;
	}

	public Dosi removeDosi(Dosi dosi) {
		getDosis().remove(dosi);
		dosi.setMedicamento(null);

		return dosi;
	}

}