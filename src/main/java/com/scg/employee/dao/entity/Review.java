package com.scg.employee.dao.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "review")
@Getter
@Setter
public class Review {
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "comment")
	private String comment;

}
