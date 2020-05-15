package com.crmunibague.crmunibague.humanresource;

import com.crmunibague.crmunibague.machinery.Machinery;
import com.crmunibague.crmunibague.workshift.WorkShift;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the human_resources database table.
 * 
 */
@Entity
@Table(name="human_resources")
@NamedQuery(name="HumanResource.findAll", query="SELECT h FROM HumanResource h")
public class HumanResource implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String dni;

	private String name;

	//bi-directional many-to-one association to WorkShift
	@ManyToOne
	@JoinColumn(name="work_shiftid")
	private WorkShift workShift;

	//bi-directional many-to-one association to Machinery
	@OneToMany(mappedBy="humanResourceBean")
	private List<Machinery> machineries;

	public HumanResource() {
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

	public List<Machinery> getMachineries() {
		return this.machineries;
	}

	public void setMachineries(List<Machinery> machineries) {
		this.machineries = machineries;
	}

	public Machinery addMachinery(Machinery machinery) {
		getMachineries().add(machinery);
		machinery.setHumanResourceBean(this);
		return machinery;
	}

	public Machinery removeMachinery(Machinery machinery) {
		getMachineries().remove(machinery);
		machinery.setHumanResourceBean(null);

		return machinery;
	}

}