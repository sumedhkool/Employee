package com.sumedh.unittesting.unittesting.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.sumedh.unittesting.unittesting.data.ItemRepository;
import com.sumedh.unittesting.unittesting.model.Item;

@RunWith(MockitoJUnitRunner.class)
public class ItemServiceTest {
	
	@InjectMocks
	private ItemService itemService;
	
	@Mock
	private ItemRepository itemRepository;
	
	
	@Test
	public void getItemList() {
		when(itemRepository.findAll()).thenReturn(Arrays.asList ((new Item(1, "abc", 10, 100))));
		List<Item> list=itemService.getItemList();
		assertEquals(list.get(0).getName(), "abc");
		
	}

}
