package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;

//@Import(Swagger.class)
@OpenAPIDefinition(
		info = @Info(
				title = "Student Project",
				version = "1.0.0",
				description = "CRUD Operations",
				termsOfService = "NareshIt", 
				contact = @Contact(name = "Send mail", email = "csprashantphuse@gmail.com"),
				license = @License(name="Apache2.0",url = "nareshit" )
					)
		)
@SpringBootApplication
public class TddExmpleWithSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TddExmpleWithSpringBootApplication.class, args);
	}

}
