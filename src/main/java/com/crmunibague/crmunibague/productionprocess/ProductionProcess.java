package com.crmunibague.crmunibague.productionprocess;

import com.crmunibague.crmunibague.productiondetail.ProductionDetail;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the production_processes database table.
 * 
 */
@Entity
@Table(name="production_processes")
@NamedQuery(name="ProductionProcess.findAll", query="SELECT p FROM ProductionProcess p")
public class ProductionProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="code_process")
	private Integer codeProcess;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="stock_produced")
	private Integer stockProduced;

	//bi-directional one-to-one association to Process
	@OneToOne
	@JoinColumn(name="code_process")
	private Process process;

	//bi-directional many-to-one association to ProductionDetail
	@ManyToOne
	@JoinColumns({
		@JoinColumn(name="detalle_produccionproduccionnum_lote", referencedColumnName="product_batch"),
		@JoinColumn(name="detalle_produccionproductsid", referencedColumnName="products_code")
		})
	private ProductionDetail productionDetail;

	public ProductionProcess() {
	}

	public Integer getCodeProcess() {
		return this.codeProcess;
	}

	public void setCodeProcess(Integer codeProcess) {
		this.codeProcess = codeProcess;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public Integer getStockProduced() {
		return this.stockProduced;
	}

	public void setStockProduced(Integer stockProduced) {
		this.stockProduced = stockProduced;
	}

	public Process getProcess() {
		return this.process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

	public ProductionDetail getProductionDetail() {
		return this.productionDetail;
	}

	public void setProductionDetail(ProductionDetail productionDetail) {
		this.productionDetail = productionDetail;
	}

}