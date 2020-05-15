package com.crmunibague.crmunibague.predecessor;

import com.crmunibague.crmunibague.process.Process;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the predecessors database table.
 * 
 */
@Entity
@Table(name="predecessors")
@NamedQuery(name="Predecessor.findAll", query="SELECT p FROM Predecessor p")
public class Predecessor implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private PredecessorPK id;

	//bi-directional many-to-one association to Process
	@ManyToOne
	private Process process;

	public Predecessor() {
	}

	public PredecessorPK getId() {
		return this.id;
	}

	public void setId(PredecessorPK id) {
		this.id = id;
	}

	public Process getProcess() {
		return this.process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

}