package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;

import java.io.Serializable;
import javax.persistence.*;

@Embeddable
public class RequestAnalysisPK implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name="code")
	private Integer code;

	@ManyToOne(optional = false)
	@JoinColumn(name="request_status", referencedColumnName="code", insertable=false, updatable=false)
	private RequestStatus requestStatus;

	public RequestAnalysisPK() {
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}


	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof RequestAnalysisPK)) {
			return false;
		}
		RequestAnalysisPK castOther = (RequestAnalysisPK)other;
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