package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the DUEÑO database table.
 * 
 */
@Entity

@NamedQuery(name="Dueño.findAll", query="SELECT m FROM Dueño m ORDER BY m.rutdueño")
public class Dueño implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="DUEÑO_RUTDUEÑO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="DUEÑO_RUTDUEÑO_GENERATOR")
	private String rutdueño;

	private String apellido;

	private String correo;

	private String direccion;

	private String nombre;

	private String telefono;

	//bi-directional many-to-one association to Mascota
	@OneToMany(mappedBy="dueño")
	private List<Mascota> mascotas;

	//bi-directional many-to-one association to Reserva
	@OneToMany(mappedBy="dueño")
	private List<Reserva> reservas;

	public Dueño() {
	}

	public String getRutdueño() {
		return this.rutdueño;
	}

	public void setRutdueño(String rutdueño) {
		this.rutdueño = rutdueño;
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
		mascota.setDueño(this);

		return mascota;
	}

	public Mascota removeMascota(Mascota mascota) {
		getMascotas().remove(mascota);
		mascota.setDueño(null);

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
		reserva.setDueño(this);

		return reserva;
	}

	public Reserva removeReserva(Reserva reserva) {
		getReservas().remove(reserva);
		reserva.setDueño(null);

		return reserva;
	}

}