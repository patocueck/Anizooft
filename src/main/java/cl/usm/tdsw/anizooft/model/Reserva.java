package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the RESERVA database table.
 * 
 */
@Entity
@NamedQuery(name="Reserva.findAll", query="SELECT r FROM Reserva r")
public class Reserva implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="RESERVA_IDRESERVA_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="RESERVA_IDRESERVA_GENERATOR")
	private long idreserva;

	private String estadoreserva;

	@Temporal(TemporalType.DATE)
	private Date fechahora;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="reserva")
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Dueño
	@ManyToOne
	@JoinColumn(name="RUTDUEÑO")
	private Dueño dueño;

	public Reserva() {
	}

	public long getIdreserva() {
		return this.idreserva;
	}

	public void setIdreserva(long idreserva) {
		this.idreserva = idreserva;
	}

	public String getEstadoreserva() {
		return this.estadoreserva;
	}

	public void setEstadoreserva(String estadoreserva) {
		this.estadoreserva = estadoreserva;
	}

	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setReserva(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setReserva(null);

		return atencion;
	}

	public Dueño getDueño() {
		return this.dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

}