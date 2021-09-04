package com.booking;

import com.booking.model.Equipment;
import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import com.booking.repository.HotelImageRepository;
import com.booking.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelBookingApplication {


	private HotelRepository hotelRepository;

	public static void main(String[] args) {
		SpringApplication.run(HotelBookingApplication.class, args);

	}

}
