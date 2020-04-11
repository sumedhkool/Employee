package com.sumedh.unittesting.unittesting.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.sumedh.unittesting.unittesting.model.Item;
import com.sumedh.unittesting.unittesting.service.ItemService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = ItemController.class)
public class ItemControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	ItemService itemService;

	@Test
	public void getItemTest() throws Exception {

		RequestBuilder request = MockMvcRequestBuilders.get("/getItem").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"abc\",\"price\":10,\"quantity\":100}"));
	}

	@Test
	public void getItemServiceTest() throws Exception {
		when(itemService.getItem()).thenReturn(new Item(1, "abc", 10, 100));

		RequestBuilder request = MockMvcRequestBuilders.get("/getItem_service").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("{\"id\":1,\"name\":\"abc\",\"price\":10,\"quantity\":100}"));
	}
	
	@Test
	public void getItemListTest() throws Exception {
		when(itemService.getItemList()).thenReturn(Arrays.asList ((new Item(1, "abc", 10, 100))));

		RequestBuilder request = MockMvcRequestBuilders.get("/getItem_list_service").accept(MediaType.APPLICATION_JSON);

		mockMvc.perform(request).andExpect(status().isOk())
				.andExpect(content().json("[{\"id\":1,\"name\":\"abc\",\"price\":10,\"quantity\":100}]"));
	}

}
