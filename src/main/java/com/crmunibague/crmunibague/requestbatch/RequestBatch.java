package com.crmunibague.crmunibague.requestbatch;

import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.requestanalysi.RequestAnalysi;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the request_batches database table.
 * 
 */
@Entity
@Table(name="request_batches")
@NamedQuery(name="RequestBatch.findAll", query="SELECT r FROM RequestBatch r")
public class RequestBatch implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name="request_date")
	private Timestamp requestDate;

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
	private RequestAnalysi requestAnalysi;

	public RequestBatch() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Timestamp getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public RequestAnalysi getRequestAnalysi() {
		return this.requestAnalysi;
	}

	public void setRequestAnalysi(RequestAnalysi requestAnalysi) {
		this.requestAnalysi = requestAnalysi;
	}

}