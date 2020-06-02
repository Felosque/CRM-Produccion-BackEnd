package com.crmunibague.crmunibague.requestanalysis;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the request_analysis database table.
 * 
 */
@Embeddable
public class RequestAnalysiPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	private Integer code;

	@Column(name="request_status", insertable=false, updatable=false)
	private Integer requestStatus;

	public RequestAnalysiPK() {
	}
	public Integer getCode() {
		return this.code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public Integer getRequestStatus() {
		return this.requestStatus;
	}
	public void setRequestStatus(Integer requestStatus) {
		this.requestStatus = requestStatus;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RequestAnalysiPK)) {
			return false;
		}
		RequestAnalysiPK castOther = (RequestAnalysiPK)other;
		return 
			this.code.equals(castOther.code)
			&& this.requestStatus.equals(castOther.requestStatus);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.code.hashCode();
		hash = hash * prime + this.requestStatus.hashCode();
		
		return hash;
	}
}