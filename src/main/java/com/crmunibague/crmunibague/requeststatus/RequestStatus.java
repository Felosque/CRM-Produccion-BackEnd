package com.crmunibague.crmunibague.requeststatus;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="request_status")
public class RequestStatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private Integer code;

	private String description;

	public RequestStatus() {
	}

	public RequestStatus(Integer code){
		this.code = code;
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

}