package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DOSIS database table.
 * 
 */
@Entity
@Table(name="DOSIS")
@NamedQuery(name="Dosi.findAll", query="SELECT d FROM Dosi d")
public class Dosi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DosiPK id;

	private BigDecimal dosis;

	//bi-directional many-to-one association to Medicamento
	@ManyToOne
	@JoinColumn(name="IDMEDICAMENTO")
	private Medicamento medicamento;

	//bi-directional many-to-one association to Receta
	@ManyToOne
	@JoinColumn(name="IDRECETA")
	private Receta receta;

	public Dosi() {
	}

	public DosiPK getId() {
		return this.id;
	}

	public void setId(DosiPK id) {
		this.id = id;
	}

	public BigDecimal getDosis() {
		return this.dosis;
	}

	public void setDosis(BigDecimal dosis) {
		this.dosis = dosis;
	}

	public Medicamento getMedicamento() {
		return this.medicamento;
	}

	public void setMedicamento(Medicamento medicamento) {
		this.medicamento = medicamento;
	}

	public Receta getReceta() {
		return this.receta;
	}

	public void setReceta(Receta receta) {
		this.receta = receta;
	}

}