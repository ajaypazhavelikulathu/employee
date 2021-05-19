package com.scg.employee.dao.Audit;

import com.scg.employee.dao.entity.Audit;

public interface Auditable {

	Audit getAudit();

	void setAudit(Audit audit);
}
