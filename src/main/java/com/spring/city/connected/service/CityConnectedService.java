package com.spring.city.connected.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.spring.city.connected.load.LoadFile;



@Service
public class CityConnectedService implements CityConnected{
	@Autowired
	private LoadFile loadFile;
	private List<String> citiesC = new ArrayList<>();


	@Override
	public String connected(String origin, String destination) {
		System.out.println("From Service Class---->Origin:"+origin +" Destination:"+destination);
		String result;
		if (origin.equals(destination)) {
			result= "YES";
			
		} else {
			Map<String, Set<String>> route = null;
			try {
				//this is when buildRoute is executed
				route = loadFile.buildRoute();
				
			} catch (Exception e) {
				throw new RuntimeException("Could not build the routes!");
			}
			if (routeExists(origin, destination, route)) {
				result = "YES";
			} else {
				result ="NO";
			}
		}
		System.out.println("From Service Class---->Result:"+result);
		return result;
	
	}
	private boolean routeExists(String ocity, String dcity, Map<String, Set<String>> route) {
		 
		if (!route.containsKey(ocity) || !route.containsKey(dcity)) {
			return false;
		}
		//The base case in recursion. 
		if (route.get(ocity).contains(dcity))
			return true;
		else {
			// the "recursive" case in recursion
			citiesC.add(ocity);
			for (String city_con : route.get(ocity)) {
			if (!citiesC.contains(city_con) && routeExists(city_con, dcity, route))
					return true;
			}
		}
		return false;
	}

}
