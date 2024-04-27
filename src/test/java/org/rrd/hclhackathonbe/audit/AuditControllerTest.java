package org.rrd.hclhackathonbe.audit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.models.TradeType;
import org.rrd.hclhackathonbe.audit.repository.AuditRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AuditControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private AuditRecordRepository auditRecordRepository;

    @BeforeEach
    void setUp() {
        auditRecordRepository.saveAll(List.of(createMockAuditRecord(1), createMockAuditRecord(2), createMockAuditRecord(3)));
    }

    @Test
    void shouldReturnHttp200() throws Exception {

        mockMvc.perform(get("/api/v1/audit")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

    }

    @Test
    void shouldReturnListOfAuditRecord() throws Exception {
        mockMvc.perform(get("/api/v1/audit")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isArray());

    }


    @Test
    void shouldReturnListOfAuditRecordWithSize() throws Exception {

        mockMvc.perform(get("/api/v1/audit")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    private AuditRecord createMockAuditRecord(int id) {
        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setId(id);
        auditRecord.setTransactionRef(UUID.randomUUID().toString());
        auditRecord.setInstrumentId(UUID.randomUUID());
        auditRecord.setTradeType(TradeType.BUY);
        auditRecord.setAuditDate(new Date());
        return auditRecord;
    }


}
