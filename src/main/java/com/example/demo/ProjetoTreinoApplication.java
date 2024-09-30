package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients(basePackages = "com.example.demo.repository")
public class ProjetoTreinoApplication {

	public static  void main(String[] args) {
		SpringApplication.run(ProjetoTreinoApplication.class, args);
	}
		
}
