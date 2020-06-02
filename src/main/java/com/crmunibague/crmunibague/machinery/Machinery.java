package com.crmunibague.crmunibague.machinery;

import com.crmunibague.crmunibague.branchoffice.BranchOffice;
import com.crmunibague.crmunibague.humanresource.HumanResource;
import com.crmunibague.crmunibague.machinerytypes.MachineryType;
import com.crmunibague.crmunibague.machinestate.MachineState;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the machinery database table.
 * 
 */
@Entity
@NamedQuery(name="Machinery.findAll", query="SELECT m FROM Machinery m")
public class Machinery implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String name;

	@Column(name="production_capacity")
	private Integer productionCapacity;

	private String reference;

	//bi-directional many-to-one association to BranchOffice
	@ManyToOne
	@JoinColumn(name="branch_office")
	private BranchOffice branchOfficeBean;

	//bi-directional many-to-one association to HumanResource
	@ManyToOne
	@JoinColumn(name="human_resource")
	private HumanResource humanResourceBean;

	//bi-directional many-to-one association to MachineState
	@ManyToOne
	@JoinColumn(name="machine_state")
	private MachineState machineStateBean;

	//bi-directional many-to-one association to MachineryType
	@ManyToOne
	@JoinColumn(name="machinery_type")
	private MachineryType machineryTypeBean;


	public Machinery() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getProductionCapacity() {
		return this.productionCapacity;
	}

	public void setProductionCapacity(Integer productionCapacity) {
		this.productionCapacity = productionCapacity;
	}

	public String getReference() {
		return this.reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public BranchOffice getBranchOfficeBean() {
		return this.branchOfficeBean;
	}

	public void setBranchOfficeBean(BranchOffice branchOfficeBean) {
		this.branchOfficeBean = branchOfficeBean;
	}

	public HumanResource getHumanResourceBean() {
		return this.humanResourceBean;
	}

	public void setHumanResourceBean(HumanResource humanResourceBean) {
		this.humanResourceBean = humanResourceBean;
	}

	public MachineState getMachineStateBean() {
		return this.machineStateBean;
	}

	public void setMachineStateBean(MachineState machineStateBean) {
		this.machineStateBean = machineStateBean;
	}

	public MachineryType getMachineryTypeBean() {
		return this.machineryTypeBean;
	}

	public void setMachineryTypeBean(MachineryType machineryTypeBean) {
		this.machineryTypeBean = machineryTypeBean;
	}

}