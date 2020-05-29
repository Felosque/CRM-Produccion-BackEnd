package com.crmunibague.crmunibague.workshift;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the work_shifts database table.
 * 
 */
@Entity
@Table(name="work_shifts")
@NamedQuery(name="WorkShift.findAll", query="SELECT w FROM WorkShift w")
public class WorkShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	@Column(name = "description", length = 255)
	private String description;

	public WorkShift() {
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