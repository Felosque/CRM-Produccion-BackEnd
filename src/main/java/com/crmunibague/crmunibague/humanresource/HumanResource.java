package com.crmunibague.crmunibague.humanresource;

import com.crmunibague.crmunibague.workshift.WorkShift;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the human_resources database table.
 * 
 */
@Entity
@Table(name="human_resources")
public class HumanResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	private String dni;

	private String name;

	//bi-directional many-to-one association to WorkShift
	@ManyToOne
	@JoinColumn(name="work_shiftid")
	private WorkShift workShift;

	public HumanResource() {
	}

	public HumanResource(Integer code){
		this.code = code;
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getDni() {
		return this.dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public WorkShift getWorkShift() {
		return this.workShift;
	}

	public void setWorkShift(WorkShift workShift) {
		this.workShift = workShift;
	}

}