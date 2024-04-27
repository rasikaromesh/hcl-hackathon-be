package org.rrd.hclhackathonbe.audit.repository;

import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.models.TradeType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuditRecordRepository extends JpaRepository<AuditRecord, Long>{
    List<AuditRecord> findByTradeType(TradeType tradeType);

}
