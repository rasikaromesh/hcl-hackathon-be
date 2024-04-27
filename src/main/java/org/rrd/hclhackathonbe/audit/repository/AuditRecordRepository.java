package org.rrd.hclhackathonbe.audit.repository;

import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long>{

}
