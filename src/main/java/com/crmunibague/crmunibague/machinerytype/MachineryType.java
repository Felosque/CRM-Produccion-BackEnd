package com.crmunibague.crmunibague.machinerytype;

import com.crmunibague.crmunibague.machinery.Machinery;
import com.crmunibague.crmunibague.machineryprocess.MachineryProcess;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the machinery_types database table.
 * 
 */
@Entity
@Table(name="machinery_types")
@NamedQuery(name="MachineryType.findAll", query="SELECT m FROM MachineryType m")
public class MachineryType implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to Machinery
	@OneToMany(mappedBy="machineryTypeBean")
	private List<Machinery> machineries;

	//bi-directional many-to-one association to MachineryProcess
	@OneToMany(mappedBy="machineryTypeBean")
	private List<MachineryProcess> machineryProcesses;

	public MachineryType() {
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

	public List<Machinery> getMachineries() {
		return this.machineries;
	}

	public void setMachineries(List<Machinery> machineries) {
		this.machineries = machineries;
	}

	public Machinery addMachinery(Machinery machinery) {
		getMachineries().add(machinery);
		machinery.setMachineryTypeBean(this);

		return machinery;
	}

	public Machinery removeMachinery(Machinery machinery) {
		getMachineries().remove(machinery);
		machinery.setMachineryTypeBean(null);

		return machinery;
	}

	public List<MachineryProcess> getMachineryProcesses() {
		return this.machineryProcesses;
	}

	public void setMachineryProcesses(List<MachineryProcess> machineryProcesses) {
		this.machineryProcesses = machineryProcesses;
	}

	public MachineryProcess addMachineryProcess(MachineryProcess machineryProcess) {
		getMachineryProcesses().add(machineryProcess);
		machineryProcess.setMachineryTypeBean(this);

		return machineryProcess;
	}

	public MachineryProcess removeMachineryProcess(MachineryProcess machineryProcess) {
		getMachineryProcesses().remove(machineryProcess);
		machineryProcess.setMachineryTypeBean(null);

		return machineryProcess;
	}

}