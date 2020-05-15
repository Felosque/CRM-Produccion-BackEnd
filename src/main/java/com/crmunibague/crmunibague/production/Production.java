package com.crmunibague.crmunibague.production;

import com.crmunibague.crmunibague.productiondetail.ProductionDetail;
import com.crmunibague.crmunibague.rawmaterialrequest.RawMaterialRequest;
import com.crmunibague.crmunibague.requestbatch.RequestBatch;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the productions database table.
 * 
 */
@Entity
@Table(name="productions")
@NamedQuery(name="Production.findAll", query="SELECT p FROM Production p")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="expiration_date")
	private Timestamp expirationDate;

	@Column(name="start_order_date")
	private Timestamp startOrderDate;

	private Time time;

	//bi-directional many-to-one association to ProductionDetail
	@OneToMany(mappedBy="production")
	private List<ProductionDetail> productionDetails;

	//bi-directional many-to-one association to RawMaterialRequest
	@OneToMany(mappedBy="production")
	private List<RawMaterialRequest> rawMaterialRequests;

	//bi-directional many-to-one association to RequestBatch
	@OneToMany(mappedBy="production")
	private List<RequestBatch> requestBatches;

	public Production() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Timestamp expirationDate) {
		this.expirationDate = expirationDate;
	}

	public Timestamp getStartOrderDate() {
		return this.startOrderDate;
	}

	public void setStartOrderDate(Timestamp startOrderDate) {
		this.startOrderDate = startOrderDate;
	}

	public Time getTime() {
		return this.time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public List<ProductionDetail> getProductionDetails() {
		return this.productionDetails;
	}

	public void setProductionDetails(List<ProductionDetail> productionDetails) {
		this.productionDetails = productionDetails;
	}

	public ProductionDetail addProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().add(productionDetail);
		productionDetail.setProduction(this);

		return productionDetail;
	}

	public ProductionDetail removeProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().remove(productionDetail);
		productionDetail.setProduction(null);

		return productionDetail;
	}

	public List<RawMaterialRequest> getRawMaterialRequests() {
		return this.rawMaterialRequests;
	}

	public void setRawMaterialRequests(List<RawMaterialRequest> rawMaterialRequests) {
		this.rawMaterialRequests = rawMaterialRequests;
	}

	public RawMaterialRequest addRawMaterialRequest(RawMaterialRequest rawMaterialRequest) {
		getRawMaterialRequests().add(rawMaterialRequest);
		rawMaterialRequest.setProduction(this);

		return rawMaterialRequest;
	}

	public RawMaterialRequest removeRawMaterialRequest(RawMaterialRequest rawMaterialRequest) {
		getRawMaterialRequests().remove(rawMaterialRequest);
		rawMaterialRequest.setProduction(null);

		return rawMaterialRequest;
	}

	public List<RequestBatch> getRequestBatches() {
		return this.requestBatches;
	}

	public void setRequestBatches(List<RequestBatch> requestBatches) {
		this.requestBatches = requestBatches;
	}

	public RequestBatch addRequestBatch(RequestBatch requestBatch) {
		getRequestBatches().add(requestBatch);
		requestBatch.setProduction(this);

		return requestBatch;
	}

	public RequestBatch removeRequestBatch(RequestBatch requestBatch) {
		getRequestBatches().remove(requestBatch);
		requestBatch.setProduction(null);

		return requestBatch;
	}

}