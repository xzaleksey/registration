package com.avalyakin.registration.index;

import com.avalyakin.registration.visits.VisitsRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.iterableWithSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class IndexControllerTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private VisitsRepository visitsRepository;

    @Before
    public void setUp() {
        visitsRepository.deleteAll();
    }

    @Test
    public void indexControllerShouldReturnHtmlPage() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Welcome to Spring")));
    }

    @Test
    public void apiControllerShouldReturnVisits() throws Exception {
        mockMvc.perform(get("/"));
        mockMvc.perform(get("/api/visits"))
                .andExpect(jsonPath("$.*.description", iterableWithSize(1)));
    }
}

