package com.spring.city.connected.load;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class LoadFile {

	@Value("${dataFileName:unknownFile}")
	private String fileName;
	
	public Map<String, Set<String>> buildRoute() {
		Map<String, Set<String>> routes = new HashMap<>();
		BufferedReader br = new BufferedReader(new InputStreamReader(LoadFile.class.getResourceAsStream(fileName)));
		try {
			if (br.ready()) {
				String line;
				while ((line = br.readLine()) != null) {
					//skip empty lines
					if (!line.trim().equals("")) {
						String cities[] = line.split(",");
						//skip single term lines
						if (cities.length == 2) {
							String city1 = cities[0].trim();
							String city2 = cities[1].trim();
							// adding the routes in both directions for ease
							addCity(routes, city1, city2);
							addCity(routes, city2, city1);
						}
					}
				}
			}
			return routes;
		} catch (IOException e) {
			throw new RuntimeException("Can not read file " + fileName);
		} finally {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
	private static void addCity(Map<String, Set<String>> routes, String cityKey, String cityValue) {
		if (!routes.containsKey(cityKey)) {
			Set<String> cityRouteList = new HashSet<>();
			cityRouteList.add(cityValue);
			routes.put(cityKey, cityRouteList);
		} else {
			routes.get(cityKey).add(cityValue);
		}
	}
	
}
