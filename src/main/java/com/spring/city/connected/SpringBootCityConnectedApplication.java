package com.spring.city.connected;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.ResourceUtils;

@SpringBootApplication
public class SpringBootCityConnectedApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(SpringBootCityConnectedApplication.class, args);

	}
}
