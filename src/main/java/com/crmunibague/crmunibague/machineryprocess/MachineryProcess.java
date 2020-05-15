package com.crmunibague.crmunibague.machineryprocess;

import com.crmunibague.crmunibague.machinerytype.MachineryType;
import com.crmunibague.crmunibague.process.Process;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the machinery_processes database table.
 * 
 */
@Entity
@Table(name="machinery_processes")
@NamedQuery(name="MachineryProcess.findAll", query="SELECT m FROM MachineryProcess m")
public class MachineryProcess implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="code_process")
	private Integer codeProcess;

	//bi-directional many-to-one association to MachineryType
	@ManyToOne
	@JoinColumn(name="machinery_type")
	private MachineryType machineryTypeBean;

	//bi-directional one-to-one association to Process
	@OneToOne
	@JoinColumn(name="code_process")
	private Process process;

	public MachineryProcess() {
	}

	public Integer getCodeProcess() {
		return this.codeProcess;
	}

	public void setCodeProcess(Integer codeProcess) {
		this.codeProcess = codeProcess;
	}

	public MachineryType getMachineryTypeBean() {
		return this.machineryTypeBean;
	}

	public void setMachineryTypeBean(MachineryType machineryTypeBean) {
		this.machineryTypeBean = machineryTypeBean;
	}

	public Process getProcess() {
		return this.process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

}