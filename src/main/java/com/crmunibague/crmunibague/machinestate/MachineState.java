package com.crmunibague.crmunibague.machinestate;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="machine_states")
public class MachineState implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer code;

	private String description;

	public MachineState() {
	}

	public MachineState(Integer code){
		this.code = code;
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
}