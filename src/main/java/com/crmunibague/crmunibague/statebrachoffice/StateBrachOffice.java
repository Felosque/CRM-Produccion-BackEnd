package com.crmunibague.crmunibague.statebrachoffice;

import com.crmunibague.crmunibague.branchoffice.BranchOffice;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the state_brach_office database table.
 * 
 */
@Entity
@Table(name="state_brach_office")
@NamedQuery(name="StateBrachOffice.findAll", query="SELECT s FROM StateBrachOffice s")
public class StateBrachOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to BranchOffice
	@OneToMany(mappedBy="stateBrachOffice")
	private List<BranchOffice> branchOffices;

	public StateBrachOffice() {
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

	public List<BranchOffice> getBranchOffices() {
		return this.branchOffices;
	}

	public void setBranchOffices(List<BranchOffice> branchOffices) {
		this.branchOffices = branchOffices;
	}

	public BranchOffice addBranchOffice(BranchOffice branchOffice) {
		getBranchOffices().add(branchOffice);
		branchOffice.setStateBrachOffice(this);

		return branchOffice;
	}

	public BranchOffice removeBranchOffice(BranchOffice branchOffice) {
		getBranchOffices().remove(branchOffice);
		branchOffice.setStateBrachOffice(null);

		return branchOffice;
	}

}