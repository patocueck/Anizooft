package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DETALLEATENCION database table.
 * 
 */
@Embeddable
public class DetalleatencionPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idatencion;

	@Column(insertable=false, updatable=false)
	private long idproductoservicio;

	public DetalleatencionPK() {
	}
	public long getIdatencion() {
		return this.idatencion;
	}
	public void setIdatencion(long idatencion) {
		this.idatencion = idatencion;
	}
	public long getIdproductoservicio() {
		return this.idproductoservicio;
	}
	public void setIdproductoservicio(long idproductoservicio) {
		this.idproductoservicio = idproductoservicio;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DetalleatencionPK)) {
			return false;
		}
		DetalleatencionPK castOther = (DetalleatencionPK)other;
		return 
			(this.idatencion == castOther.idatencion)
			&& (this.idproductoservicio == castOther.idproductoservicio);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idatencion ^ (this.idatencion >>> 32)));
		hash = hash * prime + ((int) (this.idproductoservicio ^ (this.idproductoservicio >>> 32)));
		
		return hash;
	}
}