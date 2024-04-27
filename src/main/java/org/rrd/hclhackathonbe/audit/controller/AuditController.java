package org.rrd.hclhackathonbe.audit.controller;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.dto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.service.AuditService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditService auditService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AuditRecordDto> audit() {
        return auditService.fetchAllAuditRecord();
    }
}
