package com.booking;

import com.booking.model.Hotel;
import com.booking.repository.HotelRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelBookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(HotelRepository hotelRepository){
		return args -> {
			//List<String> images = new ArrayList<>();
			//images.add("Hotel");
			//images.add("Hotel2");
			Hotel hotel = new Hotel(1L,"name", "address","agadir", "description");
			hotelRepository.save(hotel);
		};


	}

}
