package com.crmunibague.crmunibague.product;

import com.crmunibague.crmunibague.process.Process;
import com.crmunibague.crmunibague.productiondetail.ProductionDetail;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String name;

	//bi-directional many-to-one association to Process
	@OneToMany(mappedBy="product")
	private List<Process> processes;

	//bi-directional many-to-one association to ProductionDetail
	@OneToMany(mappedBy="product")
	private List<ProductionDetail> productionDetails;

	public Product() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Process> getProcesses() {
		return this.processes;
	}

	public void setProcesses(List<Process> processes) {
		this.processes = processes;
	}

	public Process addProcess(Process process) {
		getProcesses().add(process);
		process.setProduct(this);

		return process;
	}

	public Process removeProcess(Process process) {
		getProcesses().remove(process);
		process.setProduct(null);

		return process;
	}

	public List<ProductionDetail> getProductionDetails() {
		return this.productionDetails;
	}

	public void setProductionDetails(List<ProductionDetail> productionDetails) {
		this.productionDetails = productionDetails;
	}

	public ProductionDetail addProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().add(productionDetail);
		productionDetail.setProduct(this);

		return productionDetail;
	}

	public ProductionDetail removeProductionDetail(ProductionDetail productionDetail) {
		getProductionDetails().remove(productionDetail);
		productionDetail.setProduct(null);

		return productionDetail;
	}

}