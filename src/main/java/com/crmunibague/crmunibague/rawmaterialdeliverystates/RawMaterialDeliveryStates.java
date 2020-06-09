package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import com.crmunibague.crmunibague.requestdetailsrawmaterial.RequestDetailsRawMaterial;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="raw_material_delivery_states")
public class RawMaterialDeliveryStates implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code;

    @ManyToOne(optional = false)
    @JoinColumn(name="request_details_raw_materialcode")
    private RequestDetailsRawMaterial request;

    @Column(name = "date_delivery")
    private String dateDelivery;

    @Column(name = "delivery_stock")
    private Integer deliveryStock;

    public RawMaterialDeliveryStates() {
    }

    public Integer getCode() {
        return code;
    }

    public RequestDetailsRawMaterial getRequest() {
        return request;
    }

    public String getDateDelivery() {
        return dateDelivery;
    }

    public void setDateDelivery(String dateDelivery) {
        this.dateDelivery = dateDelivery;
    }

    public Integer getDeliveryStock() {
        return deliveryStock;
    }

    public void setDeliveryStock(Integer deliveryStock) {
        this.deliveryStock = deliveryStock;
    }
}
