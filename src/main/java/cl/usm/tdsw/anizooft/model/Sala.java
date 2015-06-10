package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SALA database table.
 * 
 */
@Entity
@NamedQuery(name="Sala.findAll", query="SELECT s FROM Sala s")
public class Sala implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SALA_IDSALA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SALA_IDSALA_GENERATOR")
	private long idsala;

	private String nombre;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="IDSUCURSAL")
	private Sucursal sucursal;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="sala")
	private List<Atencion> atencions;

	public Sala() {
	}

	public long getIdsala() {
		return this.idsala;
	}

	public void setIdsala(long idsala) {
		this.idsala = idsala;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setSala(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setSala(null);

		return atencion;
	}

}