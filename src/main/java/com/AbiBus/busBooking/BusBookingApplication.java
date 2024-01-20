package com.AbiBus.busBooking;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication

@OpenAPIDefinition(
		info = @Info(
				title = "Bus Booking Application Documentation",
				description = "Bus Booking Application Documentation",
				version = "v1.0",
				contact = @Contact(
						name="Gunalan"
				)
		)
)
public class BusBookingApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}




	public static void main(String[] args) {
		SpringApplication.run(BusBookingApplication.class, args);
	}

}
