package org.rrd.hclhackathonbe.audit.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecord {
    @Id
    private int id;
    private String transactionRef;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "instrument", referencedColumnName = "instrumentId")
    private Instrument instrument;
    @Enumerated(EnumType.ORDINAL)
    private TradeType tradeType;
    private Date auditDate;
}
