package com.scg.employee.dao.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.scg.employee.dao.Audit.Auditable;
import com.scg.employee.dao.Audit.CustomAuditListener;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employee_detail")
@EntityListeners(CustomAuditListener.class)
@Getter
@Setter
public class EmployeeDetails implements Auditable {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "hobby")
	private String hobby;
	@Column(name = "salary")
	private float salary;

//	@OneToOne(mappedBy = "employeeDetails", cascade = CascadeType.ALL)
//	Employee employee;

	@Embedded
	private Audit audit;

}
