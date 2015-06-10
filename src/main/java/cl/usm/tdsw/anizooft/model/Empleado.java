package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the EMPLEADO database table.
 * 
 */
@Entity
@NamedQuery(name="Empleado.findAll", query="SELECT e FROM Empleado e")
public class Empleado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="EMPLEADO_RUTEMPLEADO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="EMPLEADO_RUTEMPLEADO_GENERATOR")
	private long rutempleado;

	private String apellido;

	private String cargo;

	private String correo;

	private String especialidad;

	@Temporal(TemporalType.DATE)
	private Date fin;

	@Temporal(TemporalType.DATE)
	private Date inicio;

	private String nombre;

	private BigDecimal tipousuario;

	//bi-directional many-to-many association to Atencion
	@ManyToMany
	@JoinTable(
		name="PARTICIPACION"
		, joinColumns={
			@JoinColumn(name="RUTEMPLEADO")
			}
		, inverseJoinColumns={
			@JoinColumn(name="IDATENCION")
			}
		)
	private List<Atencion> atencions;

	//bi-directional many-to-one association to Sucursal
	@ManyToOne
	@JoinColumn(name="IDSUCURSAL")
	private Sucursal sucursal;

	public Empleado() {
	}

	public long getRutempleado() {
		return this.rutempleado;
	}

	public void setRutempleado(long rutempleado) {
		this.rutempleado = rutempleado;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCargo() {
		return this.cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getEspecialidad() {
		return this.especialidad;
	}

	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}

	public Date getFin() {
		return this.fin;
	}

	public void setFin(Date fin) {
		this.fin = fin;
	}

	public Date getInicio() {
		return this.inicio;
	}

	public void setInicio(Date inicio) {
		this.inicio = inicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public BigDecimal getTipousuario() {
		return this.tipousuario;
	}

	public void setTipousuario(BigDecimal tipousuario) {
		this.tipousuario = tipousuario;
	}

	public List<Atencion> getAtencions() {
		return this.atencions;
	}

	public void setAtencions(List<Atencion> atencions) {
		this.atencions = atencions;
	}

	public Sucursal getSucursal() {
		return this.sucursal;
	}

	public void setSucursal(Sucursal sucursal) {
		this.sucursal = sucursal;
	}

}