package com.scg.employee.dao.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.scg.employee.dao.Audit.Auditable;
import com.scg.employee.dao.Audit.CustomAuditListener;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@Table(name = "department")
@EntityListeners(CustomAuditListener.class)
@ToString
public class Department implements Auditable {
	@Id
	@Column(name = "department_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int departmentId;

	@Column(name = "department_name", unique = true)
	private String departmentName;

	@OneToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "department_id")

	private List<Employee> employees;
	@Embedded
	private Audit audit;

}
