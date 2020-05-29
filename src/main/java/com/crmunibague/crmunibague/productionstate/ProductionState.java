package com.crmunibague.crmunibague.productionstate;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "production_states")
public class ProductionState implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code;

    private String description;

    public ProductionState(){

    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
