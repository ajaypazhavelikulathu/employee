package com.scg.employee.dao.entity;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
@Getter
@Setter

public class Audit {

	@Column(name = "created_by")
	private String createdBy;

	@Column(name = "created_timestamp")
	private LocalDateTime createdTimestamp;

	@Column(name = "last_updated_by")
	private String lastUpdatedBy;

	@Column(name = "last_updated_timestamp")
	private LocalDateTime lastUpdatedTimestamp;

//	@Column(name = "record_version_no")
//	private Integer recordVersionNo;

}
