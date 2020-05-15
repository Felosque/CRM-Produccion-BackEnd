package com.crmunibague.crmunibague.productiondetail;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the production_details database table.
 * 
 */
@Embeddable
public class ProductionDetailPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="products_code", insertable=false, updatable=false)
	private Integer productsCode;

	@Column(name="product_batch", insertable=false, updatable=false)
	private Integer productBatch;

	public ProductionDetailPK() {
	}
	public Integer getProductsCode() {
		return this.productsCode;
	}
	public void setProductsCode(Integer productsCode) {
		this.productsCode = productsCode;
	}
	public Integer getProductBatch() {
		return this.productBatch;
	}
	public void setProductBatch(Integer productBatch) {
		this.productBatch = productBatch;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof ProductionDetailPK)) {
			return false;
		}
		ProductionDetailPK castOther = (ProductionDetailPK)other;
		return 
			this.productsCode.equals(castOther.productsCode)
			&& this.productBatch.equals(castOther.productBatch);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.productsCode.hashCode();
		hash = hash * prime + this.productBatch.hashCode();
		
		return hash;
	}
}