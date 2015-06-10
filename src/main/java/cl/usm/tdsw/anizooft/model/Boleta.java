package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the BOLETA database table.
 * 
 */
@Entity
@NamedQuery(name="Boleta.findAll", query="SELECT b FROM Boleta b")
public class Boleta implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="BOLETA_IDBOLETA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="BOLETA_IDBOLETA_GENERATOR")
	private long idboleta;

	@Temporal(TemporalType.DATE)
	private Date fecha;

	private BigDecimal total;

	//bi-directional many-to-one association to Atencion
	@ManyToOne
	@JoinColumn(name="IDATENCION")
	private Atencion atencion;

	public Boleta() {
	}

	public long getIdboleta() {
		return this.idboleta;
	}

	public void setIdboleta(long idboleta) {
		this.idboleta = idboleta;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public Atencion getAtencion() {
		return this.atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

}