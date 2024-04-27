package org.rrd.hclhackathonbe.audit;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/audit")
public class AuditController {
    @GetMapping
    public String audit() {
        return "Audit";
    }
}
