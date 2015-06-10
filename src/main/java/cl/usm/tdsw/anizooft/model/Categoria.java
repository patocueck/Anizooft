package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the CATEGORIA database table.
 * 
 */
@Entity
@NamedQuery(name="Categoria.findAll", query="SELECT c FROM Categoria c")
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="CATEGORIA_IDCATEGORIASSERVICIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="CATEGORIA_IDCATEGORIASSERVICIO_GENERATOR")
	private long idcategoriasservicio;

	private String nombre;

	//bi-directional many-to-one association to Productoservicio
	@OneToMany(mappedBy="categoria")
	private List<Productoservicio> productoservicios;

	public Categoria() {
	}

	public long getIdcategoriasservicio() {
		return this.idcategoriasservicio;
	}

	public void setIdcategoriasservicio(long idcategoriasservicio) {
		this.idcategoriasservicio = idcategoriasservicio;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Productoservicio> getProductoservicios() {
		return this.productoservicios;
	}

	public void setProductoservicios(List<Productoservicio> productoservicios) {
		this.productoservicios = productoservicios;
	}

	public Productoservicio addProductoservicio(Productoservicio productoservicio) {
		getProductoservicios().add(productoservicio);
		productoservicio.setCategoria(this);

		return productoservicio;
	}

	public Productoservicio removeProductoservicio(Productoservicio productoservicio) {
		getProductoservicios().remove(productoservicio);
		productoservicio.setCategoria(null);

		return productoservicio;
	}

}