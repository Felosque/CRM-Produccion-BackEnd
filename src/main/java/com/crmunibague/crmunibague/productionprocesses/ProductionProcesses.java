package com.crmunibague.crmunibague.productionprocesses;


import com.crmunibague.crmunibague.process.Process;
import com.crmunibague.crmunibague.productiondetails.ProductionDetails;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="productions_processes")
public class ProductionProcesses implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "code_process", insertable = false, updatable = false)
    private Integer codeProcess;

    @ManyToOne(optional = false)
    @JoinColumn(name="code_process", referencedColumnName = "code", insertable = false, updatable = false)
    private Process process;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "stock_produced")
    private Integer stockProduced;

    @ManyToOne
    @JoinColumns({@JoinColumn(name="detalle_produccionproduccionNum_lote", referencedColumnName = "product_batch"),@JoinColumn(name="detalle_produccionproductsid", referencedColumnName = "products_code")})
    private ProductionDetails productionDetails;

    public ProductionProcesses() {
    }

    public ProductionProcesses(Integer code) {
        this.codeProcess = code;
    }


    public Integer getCode() {
        return codeProcess;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Integer getStockProduced() {
        return stockProduced;
    }

    public void setStockProduced(Integer stockProduced) {
        this.stockProduced = stockProduced;
    }

    public ProductionDetails getProductionDetails() {
        return productionDetails;
    }

    public void setProductionDetails(ProductionDetails productionDetails) {
        this.productionDetails = productionDetails;
    }
}
