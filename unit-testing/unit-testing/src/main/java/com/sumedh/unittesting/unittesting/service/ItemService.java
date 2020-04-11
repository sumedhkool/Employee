package com.sumedh.unittesting.unittesting.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sumedh.unittesting.unittesting.data.ItemRepository;
import com.sumedh.unittesting.unittesting.model.Item;

@Component
public class ItemService {
	
	@Autowired
	private ItemRepository itemRepository;

	
	public Item getItem() {
		return new Item(1, "Bat", 100, 2);
	}
	
	public List<Item> getItemList(){
		
		return itemRepository.findAll();
	}
}
