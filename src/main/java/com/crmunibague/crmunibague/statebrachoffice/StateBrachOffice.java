package com.crmunibague.crmunibague.statebrachoffice;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="state_brach_offices")
public class StateBrachOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer code;

	private String description;

	public StateBrachOffice() {
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