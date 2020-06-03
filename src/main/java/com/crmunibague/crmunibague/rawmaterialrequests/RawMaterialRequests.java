package com.crmunibague.crmunibague.rawmaterialrequests;
import com.crmunibague.crmunibague.production.Production;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "raw_material_requests")
public class RawMaterialRequests implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "state")
    private Integer state;

    @Column(name = "request_date")
    private String requestDate;

    @Column(name = "number_order")
    private Integer numberOrder;

    @ManyToOne(optional = false)
    @JoinColumn(name="number_batch")
    private Production numberBatch;

    public RawMaterialRequests() {
    }

    public RawMaterialRequests(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public Integer getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(Integer numberOrder) {
        this.numberOrder = numberOrder;
    }

    public Production getNumberBatch() {
        return numberBatch;
    }

    public void setNumberBatch(Production numberBatch) {
        this.numberBatch = numberBatch;
    }
}
