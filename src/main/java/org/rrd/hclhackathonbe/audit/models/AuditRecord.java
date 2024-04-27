package org.rrd.hclhackathonbe.audit.models;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord {
    @Id
    private int id;
    private String transactionRef;
    private UUID instrumentId;
    @Enumerated(EnumType.ORDINAL)
    private TradeType tradeType;
    private Date auditDate;
}
