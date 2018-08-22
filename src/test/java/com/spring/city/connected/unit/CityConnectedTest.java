package com.spring.city.connected.unit;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.Assert.assertTrue;
import com.spring.city.connected.service.CityConnectedService;

public class CityConnectedTest {
	
	@Autowired
	CityConnectedService cityConnectedService;
	
	@Test 
	public void connectedTrueTest(){
	
		assertTrue("Yes".equals(cityConnectedService.connected("Boston", "Newark")));
		assertTrue("Yes".equals(cityConnectedService.connected("Newark", "Boston")));
		assertTrue("Yes".equals(cityConnectedService.connected("Boston", "Philadelphia")));
		assertTrue("Yes".equals(cityConnectedService.connected("Philadelphia", "Boston")));
		assertTrue("Yes".equals(cityConnectedService.connected("New York", "Newark")));
		assertTrue("Yes".equals(cityConnectedService.connected("Newark", "New York")));
		assertTrue("Yes".equals(cityConnectedService.connected("Boston", "New York")));
		assertTrue("Yes".equals(cityConnectedService.connected("New York", "Boston")));
		assertTrue("Yes".equals(cityConnectedService.connected("Newark", "Philadelphia")));
		assertTrue("Yes".equals(cityConnectedService.connected("Philadelphia", "Newark")));
		assertTrue("No".equals(cityConnectedService.connected("Philadelphia", "Albany")));
		assertTrue("Yes".equals(cityConnectedService.connected("Albany", "Philadelphia")));
		
		
	}
}
