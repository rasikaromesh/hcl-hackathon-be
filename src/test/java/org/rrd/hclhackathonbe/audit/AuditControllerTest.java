package org.rrd.hclhackathonbe.audit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest

@AutoConfigureMockMvc
public class AuditControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnHttp200() throws Exception {

        mockMvc.perform(get("/api/v1/audit")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

    }

}
