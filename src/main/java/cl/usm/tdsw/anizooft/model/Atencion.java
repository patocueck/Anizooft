package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the ATENCION database table.
 * 
 */
@Entity
@NamedQuery(name="Atencion.findAll", query="SELECT a FROM Atencion a")
public class Atencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ATENCION_IDATENCION_GENERATOR",sequenceName="ATENCION_SEQ", allocationSize = 1 )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ATENCION_IDATENCION_GENERATOR")
	private long idatencion;

	private String consultadiagnostico;

	private String consultatratamiento;

	private String estadoatencion;

	@Temporal(TemporalType.DATE)
	private Date fechahora;

	@Temporal(TemporalType.DATE)
	private Date hospedajetiempo;

	private BigDecimal monto;

	private String observacion;

	private String operacionnombre;

	private String operaciontratamiento;

	private String tipo;

	private BigDecimal vacunadosis;

	private String vacunanombre;

	//bi-directional many-to-one association to Analisi
	@OneToMany(mappedBy="atencion")
	private List<Analisi> analisis;

	//bi-directional many-to-one association to Mascota
	@ManyToOne
	@JoinColumn(name="IDMASCOTA")
	private Mascota mascota;

	//bi-directional many-to-one association to Reserva
	@ManyToOne
	@JoinColumn(name="IDRESERVA")
	private Reserva reserva;

	//bi-directional many-to-one association to Boleta
	@OneToMany(mappedBy="atencion")
	private List<Boleta> boletas;

	//bi-directional many-to-one association to Detalleatencion
	@OneToMany(mappedBy="atencion")
	private List<Detalleatencion> detalleatencions;

	//bi-directional many-to-many association to Empleado
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="atencions")
	//@ManyToMany(mappedBy="atencions")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Receta
	@OneToMany(mappedBy="atencion")
	private List<Receta> recetas;

	//bi-directional many-to-one association to Sala
	@ManyToOne
	@JoinColumn(name="IDSALA")
	private Sala sala;

	public Atencion() {
	}

	public long getIdatencion() {
		return this.idatencion;
	}

	public void setIdatencion(long idatencion) {
		this.idatencion = idatencion;
	}

	public String getConsultadiagnostico() {
		return this.consultadiagnostico;
	}

	public void setConsultadiagnostico(String consultadiagnostico) {
		this.consultadiagnostico = consultadiagnostico;
	}

	public String getConsultatratamiento() {
		return this.consultatratamiento;
	}

	public void setConsultatratamiento(String consultatratamiento) {
		this.consultatratamiento = consultatratamiento;
	}

	public String getEstadoatencion() {
		return this.estadoatencion;
	}

	public void setEstadoatencion(String estadoatencion) {
		this.estadoatencion = estadoatencion;
	}

	public Date getFechahora() {
		return this.fechahora;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public Date getHospedajetiempo() {
		return this.hospedajetiempo;
	}

	public void setHospedajetiempo(Date hospedajetiempo) {
		this.hospedajetiempo = hospedajetiempo;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getObservacion() {
		return this.observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public String getOperacionnombre() {
		return this.operacionnombre;
	}

	public void setOperacionnombre(String operacionnombre) {
		this.operacionnombre = operacionnombre;
	}

	public String getOperaciontratamiento() {
		return this.operaciontratamiento;
	}

	public void setOperaciontratamiento(String operaciontratamiento) {
		this.operaciontratamiento = operaciontratamiento;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public BigDecimal getVacunadosis() {
		return this.vacunadosis;
	}

	public void setVacunadosis(BigDecimal vacunadosis) {
		this.vacunadosis = vacunadosis;
	}

	public String getVacunanombre() {
		return this.vacunanombre;
	}

	public void setVacunanombre(String vacunanombre) {
		this.vacunanombre = vacunanombre;
	}

	public List<Analisi> getAnalisis() {
		return this.analisis;
	}

	public void setAnalisis(List<Analisi> analisis) {
		this.analisis = analisis;
	}

	public Analisi addAnalisi(Analisi analisi) {
		getAnalisis().add(analisi);
		analisi.setAtencion(this);

		return analisi;
	}

	public Analisi removeAnalisi(Analisi analisi) {
		getAnalisis().remove(analisi);
		analisi.setAtencion(null);

		return analisi;
	}

	public Mascota getMascota() {
		return this.mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Reserva getReserva() {
		return this.reserva;
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public List<Boleta> getBoletas() {
		return this.boletas;
	}

	public void setBoletas(List<Boleta> boletas) {
		this.boletas = boletas;
	}

	public Boleta addBoleta(Boleta boleta) {
		getBoletas().add(boleta);
		boleta.setAtencion(this);

		return boleta;
	}

	public Boleta removeBoleta(Boleta boleta) {
		getBoletas().remove(boleta);
		boleta.setAtencion(null);

		return boleta;
	}

	public List<Detalleatencion> getDetalleatencions() {
		return this.detalleatencions;
	}

	public void setDetalleatencions(List<Detalleatencion> detalleatencions) {
		this.detalleatencions = detalleatencions;
	}

	public Detalleatencion addDetalleatencion(Detalleatencion detalleatencion) {
		getDetalleatencions().add(detalleatencion);
		detalleatencion.setAtencion(this);

		return detalleatencion;
	}

	public Detalleatencion removeDetalleatencion(Detalleatencion detalleatencion) {
		getDetalleatencions().remove(detalleatencion);
		detalleatencion.setAtencion(null);

		return detalleatencion;
	}

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}
	
	public Empleado addEmpleado(Empleado empleado) {
		if (this.empleados == null)
			this.empleados = new ArrayList<Empleado>();
		if (!getEmpleados().contains(empleado))
			this.empleados.add(empleado);
		if (!empleado.getAtencions().contains(this))
			empleado.addAtencion(this);

		return empleado;
	}
	
//	public Empleado removeReceta(Empleado empleado) {
//		getRecetas().remove(empleado);
//		empleado.setAtencion(null);
//
//		return empleado;
//	}
	
	public List<Receta> getRecetas() {
		return this.recetas;
	}

	public void setRecetas(List<Receta> recetas) {
		this.recetas = recetas;
	}

	public Receta addReceta(Receta receta) {
		getRecetas().add(receta);
		receta.setAtencion(this);

		return receta;
	}

	public Receta removeReceta(Receta receta) {
		getRecetas().remove(receta);
		receta.setAtencion(null);

		return receta;
	}

	public Sala getSala() {
		return this.sala;
	}

	public void setSala(Sala sala) {
		this.sala = sala;
	}

}