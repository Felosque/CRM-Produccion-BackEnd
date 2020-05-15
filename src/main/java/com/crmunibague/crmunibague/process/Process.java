package com.crmunibague.crmunibague.process;

import com.crmunibague.crmunibague.laborresource.LaborResource;
import com.crmunibague.crmunibague.machineryprocess.MachineryProcess;
import com.crmunibague.crmunibague.predecessor.Predecessor;
import com.crmunibague.crmunibague.product.Product;
import com.crmunibague.crmunibague.productionprocess.ProductionProcess;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Time;
import java.util.List;


/**
 * The persistent class for the processes database table.
 * 
 */
@Entity
@Table(name="processes")
@NamedQuery(name="Process.findAll", query="SELECT p FROM Process p")
public class Process implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name="process_name")
	private String processName;

	@Column(name="process_order")
	private Integer processOrder;

	@Column(name="process_time")
	private Time processTime;

	@Column(name="stock_produced")
	private Integer stockProduced;

	//bi-directional many-to-one association to LaborResource
	@OneToMany(mappedBy="process")
	private List<LaborResource> laborResources;

	//bi-directional one-to-one association to MachineryProcess
	@OneToOne(mappedBy="process")
	private MachineryProcess machineryProcess;

	//bi-directional many-to-one association to Predecessor
	@OneToMany(mappedBy="process")
	private List<Predecessor> predecessors;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="products_code")
	private Product product;

	//bi-directional one-to-one association to ProductionProcess
	@OneToOne(mappedBy="process")
	private ProductionProcess productionProcess;

	public Process() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getProcessName() {
		return this.processName;
	}

	public void setProcessName(String processName) {
		this.processName = processName;
	}

	public Integer getProcessOrder() {
		return this.processOrder;
	}

	public void setProcessOrder(Integer processOrder) {
		this.processOrder = processOrder;
	}

	public Time getProcessTime() {
		return this.processTime;
	}

	public void setProcessTime(Time processTime) {
		this.processTime = processTime;
	}

	public Integer getStockProduced() {
		return this.stockProduced;
	}

	public void setStockProduced(Integer stockProduced) {
		this.stockProduced = stockProduced;
	}

	public List<LaborResource> getLaborResources() {
		return this.laborResources;
	}

	public void setLaborResources(List<LaborResource> laborResources) {
		this.laborResources = laborResources;
	}

	public LaborResource addLaborResource(LaborResource laborResource) {
		getLaborResources().add(laborResource);
		laborResource.setProcess(this);

		return laborResource;
	}

	public LaborResource removeLaborResource(LaborResource laborResource) {
		getLaborResources().remove(laborResource);
		laborResource.setProcess(null);

		return laborResource;
	}

	public MachineryProcess getMachineryProcess() {
		return this.machineryProcess;
	}

	public void setMachineryProcess(MachineryProcess machineryProcess) {
		this.machineryProcess = machineryProcess;
	}

	public List<Predecessor> getPredecessors() {
		return this.predecessors;
	}

	public void setPredecessors(List<Predecessor> predecessors) {
		this.predecessors = predecessors;
	}

	public Predecessor addPredecessor(Predecessor predecessor) {
		getPredecessors().add(predecessor);
		predecessor.setProcess(this);

		return predecessor;
	}

	public Predecessor removePredecessor(Predecessor predecessor) {
		getPredecessors().remove(predecessor);
		predecessor.setProcess(null);

		return predecessor;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public ProductionProcess getProductionProcess() {
		return this.productionProcess;
	}

	public void setProductionProcess(ProductionProcess productionProcess) {
		this.productionProcess = productionProcess;
	}

}