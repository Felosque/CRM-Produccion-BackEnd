package com.crmunibague.crmunibague.requeststatus;

import com.crmunibague.crmunibague.requestanalysi.RequestAnalysi;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the request_status database table.
 * 
 */
@Entity
@Table(name="request_status")
@NamedQuery(name="RequestStatus.findAll", query="SELECT r FROM RequestStatus r")
public class RequestStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to RequestAnalysi
	@OneToMany(mappedBy="requestStatusBean")
	private List<RequestAnalysi> requestAnalysis;

	public RequestStatus() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<RequestAnalysi> getRequestAnalysis() {
		return this.requestAnalysis;
	}

	public void setRequestAnalysis(List<RequestAnalysi> requestAnalysis) {
		this.requestAnalysis = requestAnalysis;
	}

	public RequestAnalysi addRequestAnalysi(RequestAnalysi requestAnalysi) {
		getRequestAnalysis().add(requestAnalysi);
		requestAnalysi.setRequestStatusBean(this);

		return requestAnalysi;
	}

	public RequestAnalysi removeRequestAnalysi(RequestAnalysi requestAnalysi) {
		getRequestAnalysis().remove(requestAnalysi);
		requestAnalysi.setRequestStatusBean(null);

		return requestAnalysi;
	}

}