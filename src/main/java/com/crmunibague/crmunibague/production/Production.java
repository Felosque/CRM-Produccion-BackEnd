package com.crmunibague.crmunibague.production;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="production")
public class Production implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "create_date")
    private String createDate;

    @Column(name = "expiration_date")
    private String expirationDate;

    @Column(name = "start_order_date")
    private String startOrderDate;

    private String time;


    public Production(){

    }


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getStartOrderDate() {
        return startOrderDate;
    }

    public void setStartOrderDate(String startOrderDate) {
        this.startOrderDate = startOrderDate;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
