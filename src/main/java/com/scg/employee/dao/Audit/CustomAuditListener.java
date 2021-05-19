package com.scg.employee.dao.Audit;

import java.time.LocalDateTime;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import com.scg.employee.dao.entity.Audit;

public class CustomAuditListener {

	@PrePersist
	public void setCreatedOn(final Auditable auditable) {
		var audit = auditable.getAudit();

		if (audit == null) {
			audit = new Audit();
			auditable.setAudit(audit);
		}
		final LocalDateTime now = LocalDateTime.now();
		audit.setCreatedTimestamp(now);
		audit.setLastUpdatedTimestamp(now);

		audit.setCreatedBy("ajay");
		audit.setLastUpdatedBy("Musthafa");
	}

	@PreUpdate
	public void setUpdadtedOn(final Auditable auditable) {

		final var audit = auditable.getAudit();
		audit.setLastUpdatedTimestamp(LocalDateTime.now());

		audit.setLastUpdatedBy("chinchu");

	}

}
