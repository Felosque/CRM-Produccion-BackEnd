package com.crmunibague.crmunibague.laborresources;

import com.crmunibague.crmunibague.process.Process;
import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the labor_resources database table.
 * 
 */
@Entity
@Table(name="labor_resources")
@NamedQuery(name="LaborResource.findAll", query="SELECT l FROM LaborResource l")
public class LaborResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String staff;

	//bi-directional many-to-one association to Process
	@ManyToOne
	private Process process;

	public LaborResource() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getStaff() {
		return this.staff;
	}

	public void setStaff(String staff) {
		this.staff = staff;
	}

	public Process getProcess() {
		return this.process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

}