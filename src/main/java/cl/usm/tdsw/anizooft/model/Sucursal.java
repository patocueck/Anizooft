package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the SUCURSAL database table.
 * 
 */
@Entity
@NamedQuery(name="Sucursal.findAll", query="SELECT s FROM Sucursal s")
public class Sucursal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="SUCURSAL_IDSUCURSAL_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SUCURSAL_IDSUCURSAL_GENERATOR")
	private long idsucursal;

	private String direccion;

	private String nombre;

	//bi-directional many-to-one association to Empleado
	@OneToMany(mappedBy="sucursal")
	private List<Empleado> empleados;

	//bi-directional many-to-one association to Sala
	@OneToMany(mappedBy="sucursal")
	private List<Sala> salas;

	public Sucursal() {
	}

	public long getIdsucursal() {
		return this.idsucursal;
	}

	public void setIdsucursal(long idsucursal) {
		this.idsucursal = idsucursal;
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

	public List<Empleado> getEmpleados() {
		return this.empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

	public Empleado addEmpleado(Empleado empleado) {
		getEmpleados().add(empleado);
		empleado.setSucursal(this);

		return empleado;
	}

	public Empleado removeEmpleado(Empleado empleado) {
		getEmpleados().remove(empleado);
		empleado.setSucursal(null);

		return empleado;
	}

	public List<Sala> getSalas() {
		return this.salas;
	}

	public void setSalas(List<Sala> salas) {
		this.salas = salas;
	}

	public Sala addSala(Sala sala) {
		getSalas().add(sala);
		sala.setSucursal(this);

		return sala;
	}

	public Sala removeSala(Sala sala) {
		getSalas().remove(sala);
		sala.setSucursal(null);

		return sala;
	}

}