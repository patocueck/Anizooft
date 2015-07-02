package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;

import javax.persistence.*;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;


/**
 * The persistent class for the VW_HISTORIAL database table.
 * 
 */
@Entity
@Table(name="VW_HISTORIAL")
@NamedQuery(name="VwHistorial.findAll", query="SELECT v FROM VwHistorial v")
public class VwHistorial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Temporal(TemporalType.DATE)
	private Date fechahora;

	private Long idatencion;

	@Id
	private Long idmascota;

	private String nombre;

	@Column(name="NOMBRE_DUENO")
	private String nombreDueno;

	@Column(name="NOMBRE_EMPLEADO")
	private String nombreEmpleado;

	@Column(name="RUT_EMPLEADO")
	private Long rutEmpleado;

	private String rutdueño;

	public VwHistorial() {
	}

	public Date getFechahora() {
//		Date fecha = new Date();
//		Date fechaFin = new Date(iAnoFin,iMesFin,iDiaFin);
//		fechaInicio.setYear(iAnoIni - 1900);
//		fechaFin.setYear(iAnoFin - 1900);
//		fechaInicio.setMonth(iMesIni - 1);
//		fechaFin.setMonth(iMesFin - 1);
//		fecha.setYear(this.fechahora.getYear() - 1900);
		
//		Calendar cal = Calendar.getInstance();
//		//String input = String.valueOf(inputDate);
//		cal.set(Calendar.YEAR, this.fechahora.getYear());
//		cal.set(Calendar.MONTH, this.fechahora.getMonth());
//		cal.set(Calendar.DAY_OF_MONTH, this.fechahora.getDay());
//		cal.set(Calendar.HOUR, 00);
//        cal.set(Calendar.MINUTE,00);
//        cal.set(Calendar.SECOND,00);
//		Date fechaInicio = cal.getTime();
//		return fechaInicio;
		return this.fechahora;
	}
	
	public String getFechaFormat(){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy", Locale.US);
		
		Date fecha = getFechahora();
		Integer ano = fecha.getYear();
		Integer mes = fecha.getMonth();
		Integer dia = fecha.getDay();
		
		Format formatter = new SimpleDateFormat("dd-MM-yy");
		String s = formatter.format(fecha);
		
		return s;
	}

	public void setFechahora(Date fechahora) {
		this.fechahora = fechahora;
	}

	public Long getIdatencion() {
		return this.idatencion;
	}

	public void setIdatencion(Long idatencion) {
		this.idatencion = idatencion;
	}

	public Long getIdmascota() {
		return this.idmascota;
	}

	public void setIdmascota(Long idmascota) {
		this.idmascota = idmascota;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreDueno() {
		return this.nombreDueno;
	}

	public void setNombreDueno(String nombreDueno) {
		this.nombreDueno = nombreDueno;
	}

	public String getNombreEmpleado() {
		return this.nombreEmpleado;
	}

	public void setNombreEmpleado(String nombreEmpleado) {
		this.nombreEmpleado = nombreEmpleado;
	}

	public Long getRutEmpleado() {
		return this.rutEmpleado;
	}

	public void setRutEmpleado(Long rutEmpleado) {
		this.rutEmpleado = rutEmpleado;
	}

	public String getRutdueño() {
		return this.rutdueño;
	}

	public void setRutdueño(String rutdueño) {
		this.rutdueño = rutdueño;
	}

}