package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import com.crmunibague.crmunibague.rawmaterialdeliverystate.RawMaterialDeliveryState;
import com.crmunibague.crmunibague.rawmaterialrequest.RawMaterialRequest;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the request_details_raw_material database table.
 * 
 */
@Entity
@Table(name="request_details_raw_material")
@NamedQuery(name="RequestDetailsRawMaterial.findAll", query="SELECT r FROM RequestDetailsRawMaterial r")
public class RequestDetailsRawMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name="delivery_deadline_date")
	private Timestamp deliveryDeadlineDate;

	@Column(name="request_amount")
	private Integer requestAmount;

	//bi-directional many-to-one association to RawMaterialDeliveryState
	@OneToMany(mappedBy="requestDetailsRawMaterial")
	private List<RawMaterialDeliveryState> rawMaterialDeliveryStates;

	//bi-directional one-to-one association to RawMaterialRequest
	@OneToOne
	@JoinColumn(name="code")
	private RawMaterialRequest rawMaterialRequest;

	public RequestDetailsRawMaterial() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public Timestamp getDeliveryDeadlineDate() {
		return this.deliveryDeadlineDate;
	}

	public void setDeliveryDeadlineDate(Timestamp deliveryDeadlineDate) {
		this.deliveryDeadlineDate = deliveryDeadlineDate;
	}

	public Integer getRequestAmount() {
		return this.requestAmount;
	}

	public void setRequestAmount(Integer requestAmount) {
		this.requestAmount = requestAmount;
	}

	public List<RawMaterialDeliveryState> getRawMaterialDeliveryStates() {
		return this.rawMaterialDeliveryStates;
	}

	public void setRawMaterialDeliveryStates(List<RawMaterialDeliveryState> rawMaterialDeliveryStates) {
		this.rawMaterialDeliveryStates = rawMaterialDeliveryStates;
	}

	public RawMaterialDeliveryState addRawMaterialDeliveryState(RawMaterialDeliveryState rawMaterialDeliveryState) {
		getRawMaterialDeliveryStates().add(rawMaterialDeliveryState);
		rawMaterialDeliveryState.setRequestDetailsRawMaterial(this);

		return rawMaterialDeliveryState;
	}

	public RawMaterialDeliveryState removeRawMaterialDeliveryState(RawMaterialDeliveryState rawMaterialDeliveryState) {
		getRawMaterialDeliveryStates().remove(rawMaterialDeliveryState);
		rawMaterialDeliveryState.setRequestDetailsRawMaterial(null);

		return rawMaterialDeliveryState;
	}

	public RawMaterialRequest getRawMaterialRequest() {
		return this.rawMaterialRequest;
	}

	public void setRawMaterialRequest(RawMaterialRequest rawMaterialRequest) {
		this.rawMaterialRequest = rawMaterialRequest;
	}

}