package org.rrd.hclhackathonbe.audit.service;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordPage;
import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.repository.AuditRecordRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
@RequiredArgsConstructor
public class AuditService {
    private final AuditRecordRepository auditRecordRepository;
    private final Logger logger = Logger.getLogger(AuditService.class.getName());

    public List<AuditRecordDto> fetchAllAuditRecord(AuditRecordPage auditRecordPage) {
        Sort sort = Sort.by(auditRecordPage.getSortDirection(), auditRecordPage.getSortBy());
        Pageable pageable = PageRequest.of(auditRecordPage.getPageNumber(), auditRecordPage.getPageSize(), sort);
        return auditRecordRepository.findAll(pageable).getContent().stream()
                .map(this::mapToDto)
                .toList();
    }

    private AuditRecordDto mapToDto(AuditRecord record) {
//        TODO link instrument name
        logger.info("Mapping audit record to dto");
        logger.info(record.toString());
        return new AuditRecordDto(record.getTransactionRef(), record.getInstrument().getInstrumentId(),
                record.getInstrument().getName(),
                record.getTradeType(),
                record.getAuditDate());
    }
}
