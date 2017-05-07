package com.hsbc.eqfin.pcfpoc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;



public class GreetingControllerTest {

	private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = standaloneSetup(new GreetingController()).build();
    }

    @Test
    public void testSayHelloWorld() throws Exception {
    	this.mockMvc.perform(get("/greeting"))
		.andExpect(status().isOk());

    }
}
