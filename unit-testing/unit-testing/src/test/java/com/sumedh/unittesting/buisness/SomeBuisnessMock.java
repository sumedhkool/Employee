package com.sumedh.unittesting.buisness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeBuisnessMock {
	
	@InjectMocks
	SomeBuisnessService buisnessService;
	
	@Mock
	RetrivalableService retrivalableService;
	
	@Test
	public void addTest() {
		when(retrivalableService.getVal()).thenReturn(new Integer(30));
		Integer integer=buisnessService.add(10);
		assertEquals(40, integer.intValue());
		
	}

	
	@Test
	public void add_Two_Test() {
		when(retrivalableService.getVal()).thenReturn(new Integer(-30));
		Integer integer=buisnessService.add(10);
		assertEquals(-20, integer.intValue());
		
	}

}
