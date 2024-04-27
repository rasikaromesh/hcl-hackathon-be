package org.rrd.hclhackathonbe.audit.controller;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.models.TradeType;
import org.rrd.hclhackathonbe.audit.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuditRecordDto> audit(@RequestParam Optional<TradeType> tradeType) {
        return auditService.fetchAllAuditRecord(tradeType);
    }
}
