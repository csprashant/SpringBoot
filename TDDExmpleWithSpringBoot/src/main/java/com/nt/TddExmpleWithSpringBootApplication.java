package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.swagger.models.Swagger;
@Import(Swagger.class)
@SpringBootApplication
public class TddExmpleWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddExmpleWithSpringBootApplication.class, args);
	}

}
