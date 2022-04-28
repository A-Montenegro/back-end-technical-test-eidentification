package com.eidentification.technicaltest.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class StatControllerIntegrationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void when_requestIsValid_expect_correctResponse() throws Exception {
		this.mockMvc.perform(post("/api/v2/stats/compute")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{ \"readings\": [7, 21, 5, 24, 22, 7, 18, 1] }")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(jsonPath("$", notNullValue()))
				.andExpect(jsonPath("$.maximumIncrement", is(19)));
	}

	@Test
	void when_requestIsNotValid_expect_correctResponse() throws Exception {
		this.mockMvc.perform(post("/api/v2/stats/compute")
						.contentType(MediaType.APPLICATION_JSON)
						.content("{ \"incorrect-name\": [7, 21, 5, 24, 22, 7, 18, 1] }")
						.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isBadRequest());
	}

}
