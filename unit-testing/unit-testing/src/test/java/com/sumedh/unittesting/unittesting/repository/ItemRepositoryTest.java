package com.sumedh.unittesting.unittesting.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sumedh.unittesting.unittesting.data.ItemRepository;
import com.sumedh.unittesting.unittesting.model.Item;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ItemRepositoryTest {
	
	@Autowired
	private ItemRepository  itemRepository;
	
	@Test
	public void getItemList() {
		List<Item> items=itemRepository.findAll();
		assertEquals(items.size(), 3);
	}

}
