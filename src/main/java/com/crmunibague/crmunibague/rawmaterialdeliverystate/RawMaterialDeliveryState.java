package com.crmunibague.crmunibague.rawmaterialdeliverystate;

import com.crmunibague.crmunibague.requestdetailsrawmaterial.RequestDetailsRawMaterial;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the raw_material_delivery_states database table.
 * 
 */
@Entity
@Table(name="raw_material_delivery_states")
@NamedQuery(name="RawMaterialDeliveryState.findAll", query="SELECT r FROM RawMaterialDeliveryState r")
public class RawMaterialDeliveryState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Column(name="date_delivery")
	private Timestamp dateDelivery;

	@Column(name="delivery_stock")
	private Integer deliveryStock;

	//bi-directional many-to-one association to RequestDetailsRawMaterial
	@ManyToOne
	@JoinColumn(name="fk_request_detail_code")
	private RequestDetailsRawMaterial requestDetailsRawMaterial;

	public RawMaterialDeliveryState() {
	}

	public Timestamp getDateDelivery() {
		return this.dateDelivery;
	}

	public void setDateDelivery(Timestamp dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	public Integer getDeliveryStock() {
		return this.deliveryStock;
	}

	public void setDeliveryStock(Integer deliveryStock) {
		this.deliveryStock = deliveryStock;
	}

	public RequestDetailsRawMaterial getRequestDetailsRawMaterial() {
		return this.requestDetailsRawMaterial;
	}

	public void setRequestDetailsRawMaterial(RequestDetailsRawMaterial requestDetailsRawMaterial) {
		this.requestDetailsRawMaterial = requestDetailsRawMaterial;
	}

}