package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="request_analysis")
public class RequestAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private Integer code;

	//bi-directional many-to-one association to RequestStatus
	@ManyToOne(optional = false)
	@JoinColumn(name="request_status")
	private RequestStatus requestStatus;

	public RequestAnalysis() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public RequestStatus getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(RequestStatus requestStatus) {
		this.requestStatus = requestStatus;
	}
}