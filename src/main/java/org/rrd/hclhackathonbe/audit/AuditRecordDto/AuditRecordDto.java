package org.rrd.hclhackathonbe.audit.AuditRecordDto;

import lombok.Data;

import java.util.Date;
import java.util.UUID;

@Data
public class AuditRecordDto {
    private String transactionRef;
    private UUID instrumentId;
    private String instrumentName;
    private String tradeType; // TODO make it enum
    private Date auditDate;
}
