package com.crmunibague.crmunibague.predecessors;

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

	public Predecessor() {
	}

	public PredecessorPK getId() {
		return this.id;
	}

	public void setId(PredecessorPK id) {
		this.id = id;
	}


}