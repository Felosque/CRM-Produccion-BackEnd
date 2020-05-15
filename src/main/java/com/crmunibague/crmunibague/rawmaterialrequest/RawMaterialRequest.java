package com.crmunibague.crmunibague.rawmaterialrequest;

import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.requestdetailsrawmaterial.RequestDetailsRawMaterial;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the raw_material_requests database table.
 * 
 */
@Entity
@Table(name="raw_material_requests")
@NamedQuery(name="RawMaterialRequest.findAll", query="SELECT r FROM RawMaterialRequest r")
public class RawMaterialRequest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name="number_order")
	private Integer numberOrder;

	@Column(name="request_date")
	private Timestamp requestDate;

	private Integer state;

	//bi-directional many-to-one association to Production
	@ManyToOne
	@JoinColumn(name="number_batch")
	private Production production;

	//bi-directional one-to-one association to RequestDetailsRawMaterial
	@OneToOne(mappedBy="rawMaterialRequest")
	private RequestDetailsRawMaterial requestDetailsRawMaterial;

	public RawMaterialRequest() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Integer getNumberOrder() {
		return this.numberOrder;
	}

	public void setNumberOrder(Integer numberOrder) {
		this.numberOrder = numberOrder;
	}

	public Timestamp getRequestDate() {
		return this.requestDate;
	}

	public void setRequestDate(Timestamp requestDate) {
		this.requestDate = requestDate;
	}

	public Integer getState() {
		return this.state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public RequestDetailsRawMaterial getRequestDetailsRawMaterial() {
		return this.requestDetailsRawMaterial;
	}

	public void setRequestDetailsRawMaterial(RequestDetailsRawMaterial requestDetailsRawMaterial) {
		this.requestDetailsRawMaterial = requestDetailsRawMaterial;
	}

}