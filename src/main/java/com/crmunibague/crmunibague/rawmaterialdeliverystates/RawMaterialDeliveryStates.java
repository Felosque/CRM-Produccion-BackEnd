package com.crmunibague.crmunibague.rawmaterialdeliverystates;

import com.crmunibague.crmunibague.requestdetailsrawmaterial.RequestDetailsRawMaterial;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="request_details_raw_material")
public class RawMaterialDeliveryStates implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer code;

    @ManyToOne
    @JoinColumn(name="fk_request_detail_code")
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
