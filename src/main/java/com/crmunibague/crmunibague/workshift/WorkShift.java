package com.crmunibague.crmunibague.workshift;

import com.crmunibague.crmunibague.humanresource.HumanResource;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the work_shifts database table.
 * 
 */
@Entity
@Table(name="work_shifts")
@NamedQuery(name="WorkShift.findAll", query="SELECT w FROM WorkShift w")
public class WorkShift implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer code;

	private String description;

	//bi-directional many-to-one association to HumanResource
	@OneToMany(mappedBy="workShift")
	private List<HumanResource> humanResources;

	public WorkShift() {
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

	public List<HumanResource> getHumanResources() {
		return this.humanResources;
	}

	public void setHumanResources(List<HumanResource> humanResources) {
		this.humanResources = humanResources;
	}

	public HumanResource addHumanResource(HumanResource humanResource) {
		getHumanResources().add(humanResource);
		humanResource.setWorkShift(this);

		return humanResource;
	}

	public HumanResource removeHumanResource(HumanResource humanResource) {
		getHumanResources().remove(humanResource);
		humanResource.setWorkShift(null);

		return humanResource;
	}

}