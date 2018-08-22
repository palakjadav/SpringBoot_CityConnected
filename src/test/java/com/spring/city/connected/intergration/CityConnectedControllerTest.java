package com.spring.city.connected.intergration;



import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.UnsupportedEncodingException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.spring.city.connected.service.CityConnectedService;


@RunWith(SpringRunner.class)
@SpringBootTest (classes = CityConnectedService.class)
@WebAppConfiguration

public class CityConnectedControllerTest {
	
	@Autowired
	private WebApplicationContext webContext;
	
	private MockMvc mockMvc;

	@Before
	public void setupMockMvc() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webContext)
				.build();
	}
	@Test
    public void test() throws UnsupportedEncodingException, Exception {

		String body = mockMvc.perform(get("/connected?origin=New York&destination=Boston"))
				 .andExpect(status().isOk())
				 .andReturn()
				 .getResponse()
				 .getContentAsString();
				
				assertTrue(body.equals("yes"));

        
    }

}
