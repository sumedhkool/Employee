package com.sumedh.unittesting.buisness;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SomeBuisnessService {
	
   RetrivalableService retrivalableService;
   
   


	public void setRetrivalableService(RetrivalableService retrivalableService) {
	this.retrivalableService = retrivalableService;
}




	public Integer add(Integer a) {
		return a+(retrivalableService.getVal());
		
	}
}
