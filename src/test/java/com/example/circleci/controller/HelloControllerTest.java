package com.example.circleci.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@ContextConfiguration(classes = {HelloController.class})
@ExtendWith(SpringExtension.class)
class HelloControllerTest {
	@Autowired
	private HelloController helloController;

	/**
	 * Method under test: {@link HelloController#sayHello()}
	 */
	@Test
	void testSayHello() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/");
		MockMvcBuilders.standaloneSetup(helloController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
	}

	/**
	 * Method under test: {@link HelloController#sayHello()}
	 */
	@Test
	void testSayHello2() throws Exception {
		MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/", "Uri Variables");
		MockMvcBuilders.standaloneSetup(helloController)
				.build()
				.perform(requestBuilder)
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content().contentType("text/plain;charset=ISO-8859-1"))
				.andExpect(MockMvcResultMatchers.content().string("Hello, World!"));
	}
}

