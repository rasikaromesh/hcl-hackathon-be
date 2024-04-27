package org.rrd.hclhackathonbe.audit.service;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.repository.AuditRecordRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRecordRepository auditRecordRepository;

    public List<AuditRecordDto> fetchAllAuditRecord() {
        return auditRecordRepository.findAll().stream().map((this::mapToDto)).toList();
    }

    private AuditRecordDto mapToDto(AuditRecord record) {
//        TODO link instrument name
        return new AuditRecordDto(record.getTransactionRef(), record.getInstrumentId(), null, record.getTradeType(),
                record.getAuditDate());
    }
}
