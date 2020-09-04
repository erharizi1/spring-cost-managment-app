package com.crud.cost.managment.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Expenses {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="expenses_id")
	private Long id; 
	
	@Column(name= "name")
	private String name;
	
	@Column(name="cost")
	private int cost; 
	
	@Column(name= "notes")
	private String notes;
	
	@Column(name="project_id")
	private int projectId; 
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="project_id", referencedColumnName="project_id")
//	private Project project;
//	
	public Expenses() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

//	public Project getProject() {
//		return project;
//	}
//
//	public void setProject(Project project) {
//		this.project = project;
//	}

}
