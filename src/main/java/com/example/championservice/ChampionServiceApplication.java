package com.example.championservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class ChampionServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChampionServiceApplication.class, args);
	}

}
