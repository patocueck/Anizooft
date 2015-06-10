package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ANALISIS database table.
 * 
 */
@Entity
@Table(name="ANALISIS")
@NamedQuery(name="Analisi.findAll", query="SELECT a FROM Analisi a")
public class Analisi implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ANALISIS_IDANALISIS_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ANALISIS_IDANALISIS_GENERATOR")
	private long idanalisis;

	private String nombre;

	//bi-directional many-to-one association to Atencion
	@ManyToOne
	@JoinColumn(name="IDATENCION")
	private Atencion atencion;

	public Analisi() {
	}

	public long getIdanalisis() {
		return this.idanalisis;
	}

	public void setIdanalisis(long idanalisis) {
		this.idanalisis = idanalisis;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Atencion getAtencion() {
		return this.atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

}