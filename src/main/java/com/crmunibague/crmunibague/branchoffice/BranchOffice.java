package com.crmunibague.crmunibague.branchoffice;

import com.crmunibague.crmunibague.machinery.Machinery;
import com.crmunibague.crmunibague.statebrachoffice.StateBrachOffice;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the branch_office database table.
 * 
 */
@Entity
@Table(name="branch_office")
@NamedQuery(name="BranchOffice.findAll", query="SELECT b FROM BranchOffice b")
public class BranchOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String address;

	@Column(name="enterprise_nit")
	private String enterpriseNit;

	//bi-directional many-to-one association to StateBrachOffice
	@ManyToOne
	@JoinColumn(name="state")
	private StateBrachOffice stateBrachOffice;

	//bi-directional many-to-one association to Machinery
	@OneToMany(mappedBy="branchOfficeBean")
	private List<Machinery> machineries;

	public BranchOffice() {
	}

	public Integer getCode() {
		return this.code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnterpriseNit() {
		return this.enterpriseNit;
	}

	public void setEnterpriseNit(String enterpriseNit) {
		this.enterpriseNit = enterpriseNit;
	}

	public StateBrachOffice getStateBrachOffice() {
		return this.stateBrachOffice;
	}

	public void setStateBrachOffice(StateBrachOffice stateBrachOffice) {
		this.stateBrachOffice = stateBrachOffice;
	}

	public List<Machinery> getMachineries() {
		return this.machineries;
	}

	public void setMachineries(List<Machinery> machineries) {
		this.machineries = machineries;
	}

	public Machinery addMachinery(Machinery machinery) {
		getMachineries().add(machinery);
		machinery.setBranchOfficeBean(this);

		return machinery;
	}

	public Machinery removeMachinery(Machinery machinery) {
		getMachineries().remove(machinery);
		machinery.setBranchOfficeBean(null);

		return machinery;
	}

}