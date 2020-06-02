package com.crmunibague.crmunibague.requestanalysis;

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

	public RequestAnalysi() {
	}

	public RequestAnalysiPK getId() {
		return this.id;
	}

	public void setId(RequestAnalysiPK id) {
		this.id = id;
	}

}