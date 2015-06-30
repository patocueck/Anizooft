package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;


/**
 * The persistent class for the VW_RESUMEN_ATENCIONES database table.
 * 
 */
@Entity
@Table(name="VW_RESUMEN_ATENCIONES")
//IC
//Se agregan NamedQuery (LMD/30-06-2015)
@NamedQueries({
@NamedQuery(name="VwResumenAtencione.findAll", query="SELECT v FROM VwResumenAtencione v")
//@NamedQuery(name="VwResumenAtencione.findByIdMascota", query="SELECT v FROM VwResumenAtencione v where v.idmascota = :idmascota"),
//@NamedQuery(name="VwResumenAtencione.findByRutDue�o", query="SELECT v FROM VwResumenAtencione v where v.rutdue�o = :rutdue�o"),
//@NamedQuery(name="VwResumenAtencione.findByRutEmpleado", query="SELECT v FROM VwResumenAtencione v where v.rutempleado = :rutempleado")
})
//FC
public class VwResumenAtencione implements Serializable {
	private static final long serialVersionUID = 1L;


	@Id
	private BigDecimal id;
	
	private String apellidodue�o;

	private String apellidoempleado;

	private BigDecimal atenciones;

	private String cargoempleado;

	private String especialidadempleado;

	private BigDecimal idmascota;

	private String nombredue�o;

	private String nombreempleado;

	private String nombremascota;

	private String razamascota;

	private String rutdue�o;

	private BigDecimal rutempleado;

	public VwResumenAtencione() {
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

	public BigDecimal getAtenciones() {
		return this.atenciones;
	}

	public void setAtenciones(BigDecimal atenciones) {
		this.atenciones = atenciones;
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