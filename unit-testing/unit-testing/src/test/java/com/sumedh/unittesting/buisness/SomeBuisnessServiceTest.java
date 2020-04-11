package com.sumedh.unittesting.buisness;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class Retrival implements RetrivalableService{

	@Override
	public Integer getVal() {
		
		return 30;
	}
	
}
public class SomeBuisnessServiceTest {
	
	@Test
	public void addTest() {
		SomeBuisnessService buisnessService=new SomeBuisnessService();
		buisnessService.setRetrivalableService(new Retrival());
		Integer integer=buisnessService.add(10);
		assertEquals(40, integer.intValue());
		
	}
	

}
