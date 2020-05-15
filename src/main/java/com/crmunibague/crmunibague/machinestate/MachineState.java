package com.crmunibague.crmunibague.machinestate;

import com.crmunibague.crmunibague.machinery.Machinery;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the machine_states database table.
 * 
 */
@Entity
@Table(name="machine_states")
@NamedQuery(name="MachineState.findAll", query="SELECT m FROM MachineState m")
public class MachineState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to Machinery
	@OneToMany(mappedBy="machineStateBean")
	private List<Machinery> machineries;

	public MachineState() {
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
		machinery.setMachineStateBean(this);

		return machinery;
	}

	public Machinery removeMachinery(Machinery machinery) {
		getMachineries().remove(machinery);
		machinery.setMachineStateBean(null);

		return machinery;
	}

}