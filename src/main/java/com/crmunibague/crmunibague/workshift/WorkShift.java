package com.crmunibague.crmunibague.workshift;

import org.hibernate.jdbc.Work;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the work_shifts database table.
 * 
 */
@Entity
@Table(name="work_shifts")
public class WorkShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	@Column(name = "description", length = 255)
	private String description;

	public WorkShift() {
	}

	public WorkShift(Integer code){
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