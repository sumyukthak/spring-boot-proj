package com.demo.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="emp_id")
	private long employeeId;

	@Size(min = 2, message = "The first name must contain at least 2 characters")
	@Column
	private String firstName;

	@Size(min = 2, message = "The last name must contain at least 2 characters")
	@Column
	private String lastName;

	@Email(message = "Email should be valid")
	@Column
	private String email;

	@NotNull
	@Column
	private String designation;

	@NotNull
	@ManyToOne
	@JoinColumn(name = "org_id")
	private Organization org;
	
	public Employee() {
	}

	public Employee(String firstName, String lastName, String email, String designation) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.designation = designation;
		//this.assets = asset;
	}

	public long getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Organization getOrg() {
		return org;
	}

	public void setOrg(Organization org) {
		this.org = org;
	}

}
