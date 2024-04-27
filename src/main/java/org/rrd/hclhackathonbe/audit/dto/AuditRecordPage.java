package org.rrd.hclhackathonbe.audit.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuditRecordPage {
    private int pageNumber;
    private int pageSize;
    private Sort.Direction sortDirection = Sort.Direction.ASC;
    private String sortBy = "transactionRef";
}
