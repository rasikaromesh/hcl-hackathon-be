package org.rrd.hclhackathonbe.audit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.rrd.hclhackathonbe.audit.models.AuditRecord;
import org.rrd.hclhackathonbe.audit.models.Instrument;
import org.rrd.hclhackathonbe.audit.models.TradeType;
import org.rrd.hclhackathonbe.audit.repository.AuditRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Date;
import java.util.List;
import java.util.Optional;
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
        int INSTRUMENT_ID_1 = 1;
        int INSTRUMENT_ID_2 = 2;
        int INSTRUMENT_ID_3 = 3;
        auditRecordRepository.saveAll(
                List.of(
                        createMockAuditRecord(INSTRUMENT_ID_1, Optional.of(TradeType.BUY)),
                        createMockAuditRecord(INSTRUMENT_ID_2, Optional.of(TradeType.BUY)),
                        createMockAuditRecord(INSTRUMENT_ID_3, Optional.of(TradeType.BUY)),
                        createMockAuditRecord(INSTRUMENT_ID_1, Optional.of(TradeType.SELL))
                )
        );
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

    @Test
    void shouldReturnListOfAuditRecordWithInstrumentName() throws Exception {

        mockMvc.perform(get("/api/v1/audit")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$[0].instrumentName").isNotEmpty());

    }

    @Test
    void shouldReturnListOfAuditRecordWithTradeTypeBuy() throws Exception {

        mockMvc.perform(get("/api/v1/audit?tradeType=SELL")
                        .contentType(MediaType.APPLICATION_JSON)
                ).andExpect(status().isOk())
                .andExpect(jsonPath("$").isNotEmpty());

    }

    private AuditRecord createMockAuditRecord(int id, Optional<TradeType> tradeType) {
        AuditRecord auditRecord = new AuditRecord();
        auditRecord.setId(id);
        auditRecord.setTransactionRef(UUID.randomUUID().toString());
        auditRecord.setInstrument(createMockInstrument(UUID.randomUUID()));
        auditRecord.setTradeType(tradeType.orElse(TradeType.BUY));
        auditRecord.setAuditDate(new Date());
        return auditRecord;
    }

    private Instrument createMockInstrument(UUID id) {
        Instrument instrument = new Instrument();
        instrument.setInstrumentId(id);
        instrument.setName("Instrument " + id);
        return instrument;
    }


}
