package com.kayda.user.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserControllerTest {

	@Autowired
	private WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
	}
	
	@Test
	public void whenQuerySuccess() throws Exception {
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user")
				.param("userName", "kayda")
				.param("age","18")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(3))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void testGetUserInfo() throws Exception {
		String result = mockMvc.perform(MockMvcRequestBuilders.get("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk())
		//.andExpect(MockMvcResultMatchers.jsonPath("$.userName").value("kayda"))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);
	}
	
	@Test
	public void testWhenCreateSuccess() throws Exception {
		Date currentDate = new Date();
		String contentJsonStr="{\"userName\":\"kayda\",\"password\":null,\"birthday\":"+currentDate.getTime()+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.post("/user")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(contentJsonStr))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);


	}
	
	@Test
	public void testWhenUpdateSuccess() throws Exception {
		Date currentDate = new Date(LocalDateTime.now().plusYears(1).atZone(
					ZoneId.systemDefault()).toInstant().toEpochMilli());
		String contentJsonStr="{\"id\":1,\"userName\":\"kayda\",\"password\":null,\"birthday\":"+currentDate.getTime()+"}";
		String result = mockMvc.perform(MockMvcRequestBuilders.put("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8).content(contentJsonStr))
		.andExpect(MockMvcResultMatchers.status().isOk())
		.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1))
		.andReturn().getResponse().getContentAsString();
		System.out.println(result);


	}
	
	@Test
	public void testWhenDeleteSuccess() throws Exception {
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/user/1")
				.contentType(MediaType.APPLICATION_JSON_UTF8))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
}
