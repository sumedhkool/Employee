package com.sumedh.unittesting.unittesting.data;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sumedh.unittesting.unittesting.model.Item;

public interface ItemRepository extends JpaRepository<Item,Integer>{

}
