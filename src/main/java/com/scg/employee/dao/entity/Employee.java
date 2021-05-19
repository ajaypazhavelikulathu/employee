package com.scg.employee.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.scg.employee.dao.Audit.Auditable;
import com.scg.employee.dao.Audit.CustomAuditListener;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "employees")
@EntityListeners(CustomAuditListener.class)

public class Employee implements Auditable {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "first_Name")
	private String firstName;
	@Column(name = "last_Name")
	private String lastName;

	@Column(name = "email")
	private String email;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_detail_id")
	EmployeeDetails employeeDetails;

	@ManyToOne(fetch = FetchType.EAGER, cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST,
			CascadeType.REFRESH })
	@JoinColumn(name = "department_id")
//	@JoinColumn(name = "department_id", referencedColumnName = "department_id", insertable = false, updatable = false)
	private Department department;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id")
	private List<Review> reviews;

	@Embedded
	private Audit audit;
}
