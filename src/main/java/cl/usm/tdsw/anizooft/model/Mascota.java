package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the MASCOTA database table.
 * 
 */
@Entity
@NamedQueries({
@NamedQuery(name="Mascota.findAll", query="SELECT m FROM Mascota m"),
@NamedQuery(name="Mascota.findByDueño", query="SELECT m FROM Mascota m WHERE m.dueño = :dueño")
})
public class Mascota implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MASCOTA_IDMASCOTA_GENERATOR", sequenceName="MASCOTA_SEQ", allocationSize = 1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MASCOTA_IDMASCOTA_GENERATOR")
	private long idmascota;

	private String especie;

	private String genero;

	@Temporal(TemporalType.DATE)
	private Date nacimiento;

	private String nombre;

	private BigDecimal peso;

	private String raza;

	//bi-directional many-to-one association to Atencion
	@OneToMany(mappedBy="mascota")
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Dueño
	@ManyToOne
	@JoinColumn(name="RUTDUEÑO")
	private Dueño dueño;

	public Mascota() {
	}

	public long getIdmascota() {
		return this.idmascota;
	}

	public void setIdmascota(long idmascota) {
		this.idmascota = idmascota;
	}

	public String getEspecie() {
		return this.especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getGenero() {
		return this.genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Date getNacimiento() {
		return this.nacimiento;
	}

	public void setNacimiento(Date nacimiento) {
		this.nacimiento = nacimiento;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getPeso() {
		return this.peso;
	}

	public void setPeso(BigDecimal peso) {
		this.peso = peso;
	}

	public String getRaza() {
		return this.raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Atencion addAtencion(Atencion atencion) {
		getAtencions().add(atencion);
		atencion.setMascota(this);

		return atencion;
	}

	public Atencion removeAtencion(Atencion atencion) {
		getAtencions().remove(atencion);
		atencion.setMascota(null);

		return atencion;
	}

	public Dueño getDueño() {
		return this.dueño;
	}

	public void setDueño(Dueño dueño) {
		this.dueño = dueño;
	}

}