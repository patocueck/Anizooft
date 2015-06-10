package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the PRODUCTOSERVICIO database table.
 * 
 */
@Entity
@NamedQuery(name="Productoservicio.findAll", query="SELECT p FROM Productoservicio p")
public class Productoservicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="PRODUCTOSERVICIO_IDPRODUCTOSERVICIO_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="PRODUCTOSERVICIO_IDPRODUCTOSERVICIO_GENERATOR")
	private long idproductoservicio;

	private BigDecimal monto;

	private String nombre;

	//bi-directional many-to-one association to Detalleatencion
	@OneToMany(mappedBy="productoservicio")
	private List<Detalleatencion> detalleatencions;

	//bi-directional many-to-one association to Categoria
	@ManyToOne
	@JoinColumn(name="IDCATEGORIASSERVICIO")
	private Categoria categoria;

	public Productoservicio() {
	}

	public long getIdproductoservicio() {
		return this.idproductoservicio;
	}

	public void setIdproductoservicio(long idproductoservicio) {
		this.idproductoservicio = idproductoservicio;
	}

	public BigDecimal getMonto() {
		return this.monto;
	}

	public void setMonto(BigDecimal monto) {
		this.monto = monto;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Detalleatencion> getDetalleatencions() {
		return this.detalleatencions;
	}

	public void setDetalleatencions(List<Detalleatencion> detalleatencions) {
		this.detalleatencions = detalleatencions;
	}

	public Detalleatencion addDetalleatencion(Detalleatencion detalleatencion) {
		getDetalleatencions().add(detalleatencion);
		detalleatencion.setProductoservicio(this);

		return detalleatencion;
	}

	public Detalleatencion removeDetalleatencion(Detalleatencion detalleatencion) {
		getDetalleatencions().remove(detalleatencion);
		detalleatencion.setProductoservicio(null);

		return detalleatencion;
	}

	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}