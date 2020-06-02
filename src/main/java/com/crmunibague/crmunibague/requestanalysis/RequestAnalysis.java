package com.crmunibague.crmunibague.requestanalysis;

import com.crmunibague.crmunibague.requeststatus.RequestStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="request_analysis")
public class RequestAnalysis implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RequestAnalysisPK requestAnalysisPK;

	public RequestAnalysis() {
	}

	public RequestAnalysis(RequestAnalysisPK requestAnalysisPK)
	{
		this.requestAnalysisPK = requestAnalysisPK;
	}

	public RequestAnalysisPK getRequestAnalysisPK() {
		return requestAnalysisPK;
	}

	public void setRequestAnalysisPK(RequestAnalysisPK requestAnalysisPK) {
		this.requestAnalysisPK = requestAnalysisPK;
	}
}