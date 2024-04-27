package org.rrd.hclhackathonbe.audit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.rrd.hclhackathonbe.audit.models.TradeType;

import java.util.Date;
import java.util.UUID;

@Data
@AllArgsConstructor
public class AuditRecordDto {
    private String transactionRef;
    private UUID instrumentId;
    private String instrumentName;
    private TradeType tradeType;
    private Date auditDate;
}
