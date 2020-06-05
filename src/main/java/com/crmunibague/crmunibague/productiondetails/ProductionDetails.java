package com.crmunibague.crmunibague.productiondetails;
import com.crmunibague.crmunibague.product.Product;
import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.productionstate.ProductionState;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "production_details")
public class ProductionDetails implements Serializable {
    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private ProductionDetailsPk id;

    @Column(name = "stock_products")
    private Integer stockProducts;

    @Column(name = "start_date")
    private String startDate;

    @Column(name = "end_date")
    private String endDate;

    @Column(name = "processed_products")
    private Integer processedProducts;


    //llave foranea
    @ManyToOne
    @JoinColumn(name="production_state")
    private ProductionState productionStateBean;
    /*
        //Llave fornaea primaria
        @ManyToOne
        @JoinColumn(name="product_batch",  insertable = false, updatable = false)
        private Production production;

    //llave foranea primaria
    @ManyToOne
    @JoinColumn(name="products_code",  insertable = false, updatable = false)

    private Product product;
*/
    public ProductionDetails() {
    }


    public ProductionDetailsPk getId() {
        return id;
    }

    public void setId(ProductionDetailsPk id) {
        this.id = id;
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

    public Integer getProcessedProducts() {
        return processedProducts;
    }

    public void setProcessedProducts(Integer processedProducts) {
        this.processedProducts = processedProducts;
    }

    public ProductionState getProductionStateBean() {
        return productionStateBean;
    }

    public void setProductionStateBean(ProductionState productionStateBean) {
        this.productionStateBean = productionStateBean;
    }
/*
    public Production getProduction() {
        return production;
    }

    public void setProduction(Production production) {
        this.production = production;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    */
}
