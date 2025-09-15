package com.example.ms_empleo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class MsEmpleoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsEmpleoApplication.class, args);
	}

}
