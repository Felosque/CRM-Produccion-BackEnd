package com.crmunibague.crmunibague.productionprocesses;

import com.crmunibague.crmunibague.process.Process;
import com.crmunibague.crmunibague.productiondetails.ProductionDetails;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="production_processes")
public class ProductionProcesses implements Serializable {
	private static final long serialVersionUID = 1L;

	//bi-directional one-to-one association to Process

	@Id
	@Column(name="code_process", insertable=false, updatable=false)
	private Integer codeProcess;

	@ManyToOne
	@JoinColumn(name="code_process", referencedColumnName="code", insertable=false, updatable=false)
	private Process process;

	@Column(name="end_date")
	private String endDate;

	@Column(name="start_date")
	private String startDate;

	@Column(name="stock_produced")
	private Integer stockProduced;

	//bi-directional many-to-one association to ProductionDetail
	@ManyToOne
	@JoinColumns({
			@JoinColumn(name="detalle_produccionproduccionnum_lote", referencedColumnName="product_batch"),
			@JoinColumn(name="detalle_produccionproductsid", referencedColumnName="products_code")
	})

	private ProductionDetails productionDetail;

	public ProductionProcesses() {

	}

	public ProductionProcesses(Integer codeProcess)
	{
		this.codeProcess = codeProcess;
	}

	public Integer getCodeProcess() {
		return codeProcess;
	}

	public void setCodeProcess(Integer codeProcess) {
		this.codeProcess = codeProcess;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public Integer getStockProduced() {
		return stockProduced;
	}

	public void setStockProduced(Integer stockProduced) {
		this.stockProduced = stockProduced;
	}

	public ProductionDetails getProductionDetail() {
		return productionDetail;
	}

	public void setProductionDetail(ProductionDetails productionDetail) {
		this.productionDetail = productionDetail;
	}
}
