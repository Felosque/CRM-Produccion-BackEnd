package com.crmunibague.crmunibague.requestbatches;

import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.requestanalysis.RequestAnalysis;

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
	@ManyToOne
	@JoinColumn(name="production_batch")
	private Production production;

	//bi-directional many-to-one association to RequestAnalysi
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="request_analysis_code", referencedColumnName="code"),
		@JoinColumn(name="request_analysis_status", referencedColumnName="request_status")
		})
	private RequestAnalysis requestAnalysis;

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

	public RequestAnalysis getRequestAnalysis() {
		return requestAnalysis;
	}

	public void setRequestAnalysis(RequestAnalysis requestAnalysis) {
		this.requestAnalysis = requestAnalysis;
	}
}