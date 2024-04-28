package org.rrd.hclhackathonbe.audit.repository;

import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Integer>, PagingAndSortingRepository<AuditRecord,
        Integer> {

}
