package com.crmunibague.crmunibague.productionstate;

import com.crmunibague.crmunibague.productiondetail.ProductionDetail;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the production_states database table.
 * 
 */
@Entity
@Table(name="production_states")
@NamedQuery(name="ProductionState.findAll", query="SELECT p FROM ProductionState p")
public class ProductionState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to ProductionDetail
	@OneToMany(mappedBy="productionStateBean")
	private List<ProductionDetail> productionDetails;

	public ProductionState() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<ProductionDetail> getProductionDetails() {
		return this.productionDetails;
	}

	public void setProductionDetails(List<ProductionDetail> productionDetails) {
		this.productionDetails = productionDetails;
	}

	public ProductionDetail addProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().add(productionDetail);
		productionDetail.setProductionStateBean(this);

		return productionDetail;
	}

	public ProductionDetail removeProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().remove(productionDetail);
		productionDetail.setProductionStateBean(null);

		return productionDetail;
	}

}