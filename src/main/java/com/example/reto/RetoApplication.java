package com.example.reto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.IOException;

@SpringBootApplication
public class RetoApplication {

	public static void main(String[] args) {
		String command = "C:\\xampp\\mysql\\bin\\mysqld.exe";
		try{
			Process process = Runtime.getRuntime().exec(command);
			Process process1 = Runtime.getRuntime().exec("C:\\xampp\\apache\\bin\\httpd.exe");
		}catch (IOException e){
			e.printStackTrace();
		}
		SpringApplication.run(RetoApplication.class, args);
	}
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedOrigins("http://localhost:8000");;
			}
		};
	}

}
