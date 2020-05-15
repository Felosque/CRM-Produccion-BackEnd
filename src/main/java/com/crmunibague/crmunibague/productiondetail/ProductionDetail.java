package com.crmunibague.crmunibague.productiondetail;

import com.crmunibague.crmunibague.product.Product;
import com.crmunibague.crmunibague.production.Production;
import com.crmunibague.crmunibague.productionprocess.ProductionProcess;
import com.crmunibague.crmunibague.productionstate.ProductionState;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the production_details database table.
 * 
 */
@Entity
@Table(name="production_details")
@NamedQuery(name="ProductionDetail.findAll", query="SELECT p FROM ProductionDetail p")
public class ProductionDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private ProductionDetailPK id;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="processed_products")
	private Integer processedProducts;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="stock_products")
	private Integer stockProducts;

	//bi-directional many-to-one association to ProductionState
	@ManyToOne
	@JoinColumn(name="production_state")
	private ProductionState productionStateBean;

	//bi-directional many-to-one association to Production
	@ManyToOne
	@JoinColumn(name="product_batch")
	private Production production;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="products_code")
	private Product product;

	//bi-directional many-to-one association to ProductionProcess
	@OneToMany(mappedBy="productionDetail")
	private List<ProductionProcess> productionProcesses;

	public ProductionDetail() {
	}

	public ProductionDetailPK getId() {
		return this.id;
	}

	public void setId(ProductionDetailPK id) {
		this.id = id;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Integer getProcessedProducts() {
		return this.processedProducts;
	}

	public void setProcessedProducts(Integer processedProducts) {
		this.processedProducts = processedProducts;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Integer getStockProducts() {
		return this.stockProducts;
	}

	public void setStockProducts(Integer stockProducts) {
		this.stockProducts = stockProducts;
	}

	public ProductionState getProductionStateBean() {
		return this.productionStateBean;
	}

	public void setProductionStateBean(ProductionState productionStateBean) {
		this.productionStateBean = productionStateBean;
	}

	public Production getProduction() {
		return this.production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<ProductionProcess> getProductionProcesses() {
		return this.productionProcesses;
	}

	public void setProductionProcesses(List<ProductionProcess> productionProcesses) {
		this.productionProcesses = productionProcesses;
	}

	public ProductionProcess addProductionProcess(ProductionProcess productionProcess) {
		getProductionProcesses().add(productionProcess);
		productionProcess.setProductionDetail(this);

		return productionProcess;
	}

	public ProductionProcess removeProductionProcess(ProductionProcess productionProcess) {
		getProductionProcesses().remove(productionProcess);
		productionProcess.setProductionDetail(null);

		return productionProcess;
	}

}