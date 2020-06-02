<<<<<<< HEAD
package com.crmunibague.crmunibague.branchoffice;

import com.crmunibague.crmunibague.statebrachoffice.StateBranchOffice;

import java.io.Serializable;
import javax.persistence.*;


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
	private StateBranchOffice stateBrachOffice;

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

	public StateBranchOffice getStateBrachOffice() {
		return this.stateBrachOffice;
	}

	public void setStateBrachOffice(StateBranchOffice stateBrachOffice) {
		this.stateBrachOffice = stateBrachOffice;
	}

=======
package com.crmunibague.crmunibague.branchoffice;

import com.crmunibague.crmunibague.statebranchoffice.StateBranchOffice;

import java.io.Serializable;
import javax.persistence.*;


@Entity
@Table(name="branch_office")
public class BranchOffice implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	private String address;

	@Column(name="enterprise_nit")
	private String enterpriseNit;

	//bi-directional many-to-one association to StateBrachOffice
	@ManyToOne(optional = false)
	@JoinColumn(name="state")
	private StateBranchOffice stateBranchOffice;

	public BranchOffice() {
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEnterpriseNit() {
		return enterpriseNit;
	}

	public void setEnterpriseNit(String enterpriseNit) {
		this.enterpriseNit = enterpriseNit;
	}

	public StateBranchOffice getStateBranchOffice() {
		return stateBranchOffice;
	}

	public void setStateBranchOffice(StateBranchOffice state) {
		this.stateBranchOffice = state;
	}
>>>>>>> Javico_classes
}