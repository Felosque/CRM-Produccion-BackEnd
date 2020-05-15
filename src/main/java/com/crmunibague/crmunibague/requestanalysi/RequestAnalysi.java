package com.crmunibague.crmunibague.requestanalysi;

import com.crmunibague.crmunibague.requestbatch.RequestBatch;
import com.crmunibague.crmunibague.requeststatus.RequestStatus;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the request_analysis database table.
 * 
 */
@Entity
@Table(name="request_analysis")
@NamedQuery(name="RequestAnalysi.findAll", query="SELECT r FROM RequestAnalysi r")
public class RequestAnalysi implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private RequestAnalysiPK id;

	//bi-directional many-to-one association to RequestStatus
	@ManyToOne
	@JoinColumn(name="request_status")
	private RequestStatus requestStatusBean;

	//bi-directional many-to-one association to RequestBatch
	@OneToMany(mappedBy="requestAnalysi")
	private List<RequestBatch> requestBatches;

	public RequestAnalysi() {
	}

	public RequestAnalysiPK getId() {
		return this.id;
	}

	public void setId(RequestAnalysiPK id) {
		this.id = id;
	}

	public RequestStatus getRequestStatusBean() {
		return this.requestStatusBean;
	}

	public void setRequestStatusBean(RequestStatus requestStatusBean) {
		this.requestStatusBean = requestStatusBean;
	}

	public List<RequestBatch> getRequestBatches() {
		return this.requestBatches;
	}

	public void setRequestBatches(List<RequestBatch> requestBatches) {
		this.requestBatches = requestBatches;
	}

	public RequestBatch addRequestBatch(RequestBatch requestBatch) {
		getRequestBatches().add(requestBatch);
		requestBatch.setRequestAnalysi(this);

		return requestBatch;
	}

	public RequestBatch removeRequestBatch(RequestBatch requestBatch) {
		getRequestBatches().remove(requestBatch);
		requestBatch.setRequestAnalysi(null);

		return requestBatch;
	}

}