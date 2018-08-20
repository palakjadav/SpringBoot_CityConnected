package com.spring.city.connected.controller;


import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.city.connected.service.CityConnectedService;



@RestController
public class CityConnectedController {

	@Autowired
	CityConnectedService cityConnectedService;

	@RequestMapping(value="/connected", params ={"origin","destination"}, method = RequestMethod.GET)
	public String connected(@RequestParam("origin") String origin, @RequestParam("destination") String destination) {
		return cityConnectedService.connected(origin, destination);
	}
	

}
