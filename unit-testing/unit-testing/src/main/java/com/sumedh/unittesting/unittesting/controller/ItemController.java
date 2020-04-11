package com.sumedh.unittesting.unittesting.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sumedh.unittesting.unittesting.model.Item;
import com.sumedh.unittesting.unittesting.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	private ItemService itemService;
	

	@GetMapping("/getItem")
	public  Item getItem() {
		return new Item(1,"abc",10,100);
	}
	
	@GetMapping("/getItem_service")
	public  Item getItem_service() {
		return itemService.getItem();
	}
	
	@GetMapping("/getItem_list_service")
	public  List<Item> getItemList() {
		return itemService.getItemList();
	}
}
