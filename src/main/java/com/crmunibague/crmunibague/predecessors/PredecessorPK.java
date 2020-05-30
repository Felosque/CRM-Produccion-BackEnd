package com.crmunibague.crmunibague.predecessors;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the predecessors database table.
 * 
 */
@Embeddable
public class PredecessorPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer code;

	@Column(name="process_code", insertable=false, updatable=false)
	private Integer processCode;

	public PredecessorPK() {
	}
	public Integer getCode() {
		return this.code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getProcessCode() {
		return this.processCode;
	}
	public void setProcessCode(Integer processCode) {
		this.processCode = processCode;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof PredecessorPK)) {
			return false;
		}
		PredecessorPK castOther = (PredecessorPK)other;
		return 
			this.code.equals(castOther.code)
			&& this.processCode.equals(castOther.processCode);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.processCode.hashCode();
		
		return hash;
	}
}