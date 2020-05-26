package com.crmunibague.crmunibague.productiondetails;
import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "production_details")
public class ProductionDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer code;

    @Column(name = "stock_products")
    private Integer stockProducts;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "processed_products")
    private String processedProducts;

    public ProductionDetails() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getStockProducts() {
        return stockProducts;
    }

    public void setStockProducts(Integer stockProducts) {
        this.stockProducts = stockProducts;
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

    public String getProcessedProducts() {
        return processedProducts;
    }

    public void setProcessedProducts(String processedProducts) {
        this.processedProducts = processedProducts;
    }
}
