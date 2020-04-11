package com.sumedh.unittesting.unittesting.controller;

import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


@RunWith(SpringRunner.class)
@WebMvcTest(value=HelloWorldController.class)
public class HelloworldControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void helloworldTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/hello-world").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk()).andExpect((ResultMatcher) content().string("helloWorld"));

	}

}
