package com.crmunibague.crmunibague.machinerytypes;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the machinery_types database table.
 * 
 */
@Entity
@Table(name="machinery_types")
public class MachineryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	private String description;

	public MachineryType() {
	}

	public MachineryType(Integer code) {
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