package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the VW_ATENCIONES database table.
 * 
 */
@Entity
@Table(name="VW_ATENCIONES")
//IC
//Se agregan NamedQuery (LMD/30-06-2015)
@NamedQueries({
@NamedQuery(name="VwAtencione.findAll", query="SELECT v FROM VwAtencione v"),
@NamedQuery(name="VwAtencione.findByRutDue�o", query="SELECT v FROM VwAtencione v where v.rutdue�o = :rutdue�o"),
@NamedQuery(name="VwAtencione.findByRutEmpleado", query="SELECT v FROM VwAtencione v where v.rutempleado = :rutempleado"),
@NamedQuery(name="VwAtencione.findByIdMascota", query="SELECT v FROM VwAtencione v where v.idmascota = :idmascota"),
@NamedQuery(name="VwAtencione.findByFechaHoraAtencion", query="SELECT v FROM VwAtencione v where v.fechahoraatencion >= :fechahoraatencion and v.fechahoraatencion <= :fechahoraatencion")
})
//FC
public class VwAtencione implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private BigDecimal id;
	
	private String apellidodue�o;

	private String apellidoempleado;

	private String cargoempleado;

	private String especialidadempleado;

	private String estadoatencion;

	@Temporal(TemporalType.DATE)
	private Date fechahoraatencion;

	private BigDecimal idmascota;

	private String nombredue�o;

	private String nombreempleado;

	private String nombremascota;

	private String razamascota;

	private String rutdue�o;

	private BigDecimal rutempleado;

	public VwAtencione() {
	}

	public String getApellidodue�o() {
		return this.apellidodue�o;
	}

	public void setApellidodue�o(String apellidodue�o) {
		this.apellidodue�o = apellidodue�o;
	}

	public String getApellidoempleado() {
		return this.apellidoempleado;
	}

	public void setApellidoempleado(String apellidoempleado) {
		this.apellidoempleado = apellidoempleado;
	}

	public String getCargoempleado() {
		return this.cargoempleado;
	}

	public void setCargoempleado(String cargoempleado) {
		this.cargoempleado = cargoempleado;
	}

	public String getEspecialidadempleado() {
		return this.especialidadempleado;
	}

	public void setEspecialidadempleado(String especialidadempleado) {
		this.especialidadempleado = especialidadempleado;
	}

	public String getEstadoatencion() {
		return this.estadoatencion;
	}

	public void setEstadoatencion(String estadoatencion) {
		this.estadoatencion = estadoatencion;
	}

	public Date getFechahoraatencion() {
		return this.fechahoraatencion;
	}

	public void setFechahoraatencion(Date fechahoraatencion) {
		this.fechahoraatencion = fechahoraatencion;
	}

	public BigDecimal getId() {
		return this.id;
	}

	public void setId(BigDecimal id) {
		this.id = id;
	}

	public BigDecimal getIdmascota() {
		return this.idmascota;
	}

	public void setIdmascota(BigDecimal idmascota) {
		this.idmascota = idmascota;
	}

	public String getNombredue�o() {
		return this.nombredue�o;
	}

	public void setNombredue�o(String nombredue�o) {
		this.nombredue�o = nombredue�o;
	}

	public String getNombreempleado() {
		return this.nombreempleado;
	}

	public void setNombreempleado(String nombreempleado) {
		this.nombreempleado = nombreempleado;
	}

	public String getNombremascota() {
		return this.nombremascota;
	}

	public void setNombremascota(String nombremascota) {
		this.nombremascota = nombremascota;
	}

	public String getRazamascota() {
		return this.razamascota;
	}

	public void setRazamascota(String razamascota) {
		this.razamascota = razamascota;
	}

	public String getRutdue�o() {
		return this.rutdue�o;
	}

	public void setRutdue�o(String rutdue�o) {
		this.rutdue�o = rutdue�o;
	}

	public BigDecimal getRutempleado() {
		return this.rutempleado;
	}

	public void setRutempleado(BigDecimal rutempleado) {
		this.rutempleado = rutempleado;
	}

}