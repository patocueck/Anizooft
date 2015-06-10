package cl.usm.tdsw.anizooft.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the DOSIS database table.
 * 
 */
@Embeddable
public class DosiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(insertable=false, updatable=false)
	private long idmedicamento;

	@Column(insertable=false, updatable=false)
	private long idreceta;

	public DosiPK() {
	}
	public long getIdmedicamento() {
		return this.idmedicamento;
	}
	public void setIdmedicamento(long idmedicamento) {
		this.idmedicamento = idmedicamento;
	}
	public long getIdreceta() {
		return this.idreceta;
	}
	public void setIdreceta(long idreceta) {
		this.idreceta = idreceta;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof DosiPK)) {
			return false;
		}
		DosiPK castOther = (DosiPK)other;
		return 
			(this.idmedicamento == castOther.idmedicamento)
			&& (this.idreceta == castOther.idreceta);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + ((int) (this.idmedicamento ^ (this.idmedicamento >>> 32)));
		hash = hash * prime + ((int) (this.idreceta ^ (this.idreceta >>> 32)));
		
		return hash;
	}
}