package com.crmunibague.crmunibague.requestbatches;

import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.requestanalysis.RequestAnalysis;
import com.crmunibague.crmunibague.requeststatus.RequestStatus;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="request_batches")
public class RequestBatches implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	@Column(name="request_date")
	private String requestDate;

	//bi-directional many-to-one association to Production
	@ManyToOne(optional = false)
	@JoinColumn(name="production_batch")
	private Production production;

	@ManyToOne(optional = false)
	@JoinColumn(name="request_statuscode")
	private RequestStatus state;

	public RequestBatches() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public RequestStatus getState() {
		return state;
	}

	public void setState(RequestStatus state) {
		this.state = state;
	}
}