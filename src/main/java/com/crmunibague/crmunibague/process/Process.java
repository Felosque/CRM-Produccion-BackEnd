package com.crmunibague.crmunibague.process;

import com.crmunibague.crmunibague.product.Product;

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

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="products_code")
	private Product product;


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

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}