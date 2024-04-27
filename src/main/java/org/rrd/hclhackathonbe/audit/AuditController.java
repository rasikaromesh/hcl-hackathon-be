package org.rrd.hclhackathonbe.audit;

import lombok.RequiredArgsConstructor;
import org.rrd.hclhackathonbe.audit.AuditRecordDto.AuditRecordDto;
import org.rrd.hclhackathonbe.audit.AuditService.AuditService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/audit")
public class AuditController {

    private final AuditService auditService;
    @GetMapping
    public ArrayList<AuditRecordDto> audit() {
        auditService.fetchAllAuditRecord();
        return new ArrayList<AuditRecordDto>(){};
    }
}
