package com.sumedh.unittesting.buisness;

import org.springframework.stereotype.Component;

@Component
public class RetrivalService implements RetrivalableService{

	@Override
	public Integer getVal() {
		return 20;
	}

}
