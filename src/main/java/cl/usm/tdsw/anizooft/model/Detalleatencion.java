package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the DETALLEATENCION database table.
 * 
 */
@Entity
@NamedQuery(name="Detalleatencion.findAll", query="SELECT d FROM Detalleatencion d")
public class Detalleatencion implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private DetalleatencionPK id;

	private BigDecimal cantidad;

	private BigDecimal subtotal;

	//bi-directional many-to-one association to Atencion
	@ManyToOne
	@JoinColumn(name="IDATENCION")
	private Atencion atencion;

	//bi-directional many-to-one association to Productoservicio
	@ManyToOne
	@JoinColumn(name="IDPRODUCTOSERVICIO")
	private Productoservicio productoservicio;

	public Detalleatencion() {
	}

	public DetalleatencionPK getId() {
		return this.id;
	}

	public void setId(DetalleatencionPK id) {
		this.id = id;
	}

	public BigDecimal getCantidad() {
		return this.cantidad;
	}

	public void setCantidad(BigDecimal cantidad) {
		this.cantidad = cantidad;
	}

	public BigDecimal getSubtotal() {
		return this.subtotal;
	}

	public void setSubtotal(BigDecimal subtotal) {
		this.subtotal = subtotal;
	}

	public Atencion getAtencion() {
		return this.atencion;
	}

	public void setAtencion(Atencion atencion) {
		this.atencion = atencion;
	}

	public Productoservicio getProductoservicio() {
		return this.productoservicio;
	}

	public void setProductoservicio(Productoservicio productoservicio) {
		this.productoservicio = productoservicio;
	}

}