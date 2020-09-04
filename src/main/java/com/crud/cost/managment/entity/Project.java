package com.crud.cost.managment.entity;

import java.sql.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Project {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="project_id")
	private Long id; 
	
	@Column(name= "name")
	private String name;
	
	@Column(name="expected_cost")
	private int expectedCost; 
	
	@Column(name= "notes")
	private String notes;
	
	
	@Column(name= "starting_date", columnDefinition="DATETIME")
	private Date startingDate;
	
	@Column(name= "end_date", columnDefinition="DATETIME")
	private Date endDate;
	
//	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "project_id")
//	private List<Expenses> expenses;
	
	@Column(name="user_id")
	private int userId; 
	
	@Column(name="last_modified", columnDefinition="DATETIME")
	private Date lastModified;
	
//	@ManyToOne(fetch = FetchType.EAGER)
//	@JoinColumn(name="user_id", referencedColumnName="user_id")
//	private User user;

	public Project() {
		// TODO Auto-generated constructor stub
	}
	
	public Project(Long id, String name, int expectedCost, String notes, Date startingDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.expectedCost = expectedCost;
		this.notes = notes;
		this.startingDate = startingDate;
		this.endDate = endDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getExpectedCost() {
		return expectedCost;
	}

	public void setExpectedCost(int expectedCost) {
		this.expectedCost = expectedCost;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public Date getStartingDate() {
		return startingDate;
	}

	public void setStartingDate(Date startingDate) {
		this.startingDate = startingDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

//	@Override
//	public String toString() {
//		return "Project [id=" + id + ", name=" + name + ", expectedCost=" + expectedCost + ", notes=" + notes
//				+ ", startingDate=" + startingDate + ", endDate=" + endDate + ", expenses=" + expenses + "]";
//	}
//
//	public List<Expenses> getExpenses() {
//		return expenses;
//	}
//
//	public void setExpenses(List<Expenses> expenses) {
//		this.expenses = expenses;
//	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Date getLastModified() {
		return lastModified;
	}

	public void setLastModified(Date lastModified) {
		this.lastModified = lastModified;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
	
//	@Column(name= "last_updated")
//	@UpdateTimestamp
//	private Date lastUpdated;
//	
//	@Column(name= "user")
//	private String user;

}
