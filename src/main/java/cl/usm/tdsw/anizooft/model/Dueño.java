package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DUE�O database table.
 * 
 */
@Entity

@NamedQuery(name="Due�o.findAll", query="SELECT m FROM Due�o m ORDER BY m.rutdue�o")
public class Due�o implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DUE�O_RUTDUE�O_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUE�O_RUTDUE�O_GENERATOR")
	private String rutdue�o;

	private String apellido;

	private String correo;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="due�o")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="due�o")
	private List<Reserva> reservas;

	public Due�o() {
	}

	public String getRutdue�o() {
		return this.rutdue�o;
	}

	public void setRutdue�o(String rutdue�o) {
		this.rutdue�o = rutdue�o;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return this.correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Mascota> getMascotas() {
		return this.mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}

	public Mascota addMascota(Mascota mascota) {
		getMascotas().add(mascota);
		mascota.setDue�o(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setDue�o(null);

		return mascota;
	}

	public List<Reserva> getReservas() {
		return this.reservas;
	}

	public void setReservas(List<Reserva> reservas) {
		this.reservas = reservas;
	}

	public Reserva addReserva(Reserva reserva) {
		getReservas().add(reserva);
		reserva.setDue�o(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setDue�o(null);

		return reserva;
	}

}