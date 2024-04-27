package org.rrd.hclhackathonbe.audit.service;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.models.TradeType;
import org.rrd.hclhackathonbe.audit.repository.AuditRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRecordRepository auditRecordRepository;

    public List<AuditRecordDto> fetchAllAuditRecord(Optional<TradeType> tradeType) {
        return tradeType
                .map(type -> auditRecordRepository.findByTradeType(type).stream().map((this::mapToDto)).toList())
                .orElseGet(() -> auditRecordRepository.findAll().stream().map((this::mapToDto)).toList());
    }

    private AuditRecordDto mapToDto(AuditRecord record) {
//        TODO link instrument name
        return new AuditRecordDto(record.getTransactionRef(), record.getInstrument().getInstrumentId(),
                record.getInstrument().getName(),
                record.getTradeType(),
                record.getAuditDate());
    }
}
