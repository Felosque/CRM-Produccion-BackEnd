package com.crmunibague.crmunibague.production;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="productions")
public class Production implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	@Column(name="create_date")
	private String createDate;

	@Column(name="expiration_date")
	private String expirationDate;

	@Column(name="start_order_date")
	private String startOrderDate;

	private String time;

	public Production() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(String expirationDate) {
		this.expirationDate = expirationDate;
	}

	public String getStartOrderDate() {
		return this.startOrderDate;
	}

	public void setStartOrderDate(String startOrderDate) {
		this.startOrderDate = startOrderDate;
	}

	public String getTime() {
		return this.time;
	}

	public void setTime(String time) {
		this.time = time;
	}

}