package com.crmunibague.crmunibague.requestdetailsrawmaterial;

import com.crmunibague.crmunibague.rawmaterialrequests.RawMaterialRequests;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="request_details_raw_material")
public class RequestDetailsRawMaterial implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code", insertable = false, updatable = false)
    private Integer code;

    @ManyToOne(optional = false)
    @JoinColumn(name="code", referencedColumnName = "code", insertable = false, updatable = false)
    private RawMaterialRequests rawMaterialRequests;

    @Column(name = "request_amount")
    private Integer requestAmount;

    @Column(name = "delivery_deadline_date")
    private String deliveryDeadlineDate;

    public RequestDetailsRawMaterial() {
    }

    public RequestDetailsRawMaterial(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public RawMaterialRequests getRawMaterialRequests() {
        return rawMaterialRequests;
    }

    public void setRawMaterialRequests(RawMaterialRequests rawMaterialRequests) {
        this.rawMaterialRequests = rawMaterialRequests;
    }

    public Integer getRequestAmount() {
        return requestAmount;
    }

    public void setRequestAmount(Integer requestAmount) {
        this.requestAmount = requestAmount;
    }

    public String getDeliveryDeadlineDate() {
        return deliveryDeadlineDate;
    }

    public void setDeliveryDeadlineDate(String deliveryDeadlineDate) {
        this.deliveryDeadlineDate = deliveryDeadlineDate;
    }
}
