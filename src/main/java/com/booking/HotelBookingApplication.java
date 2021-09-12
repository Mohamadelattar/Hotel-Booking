package com.booking;

import com.booking.model.*;
import com.booking.repository.CityRepository;
import com.booking.repository.CountryRepository;
import com.booking.repository.HotelImageRepository;
import com.booking.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.jca.context.SpringContextResourceAdapter;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class HotelBookingApplication {


	public static void main(String[] args) {
		ApplicationContext applicationContext= SpringApplication.run(HotelBookingApplication.class, args);
//		HotelRepository hotelRepository = applicationContext.getBean(HotelRepository.class);
//		CityRepository cityRepository = applicationContext.getBean(CityRepository.class);
//		CountryRepository countryRepository = applicationContext.getBean(CountryRepository.class);
//
//		Hotel hotel = new Hotel();
//		Country country = new Country();
//		country.setName("Morocco");
//		countryRepository.save(country);
//		City city = new City();
//		city.setName("Marrakech");
//		city.setCountry(country);
//		cityRepository.save(city);
//		hotel.setName("Riad Marrakech");
//		hotel.setDescription("welcome to our hotel");
//		hotel.setAdress("Quartier El Hana");
//		hotel.setCity(city);
//		hotelRepository.save(hotel);
//
//		Hotel hotel2 = new Hotel();
//		Country country2 = new Country();
//		country2.setName("France");
//		countryRepository.save(country2);
//		City city2 = new City();
//		city2.setName("Paris");
//		city2.setCountry(country2);
//		cityRepository.save(city2);
//		hotel2.setName("Riad Paris");
//		hotel2.setDescription("welcome to our riad");
//		hotel2.setAdress("Champs Ellyses");
//		hotel2.setCity(city2);
//		hotelRepository.save(hotel2);
	}

//	@Transactional
//	public void init(){
//		Hotel hotel = new Hotel();
//		Country country = new Country();
//		country.setName("Morocco");
//		City city = new City();
//		city.setName("Marrakech");
//		city.setCountry(country);
//		hotel.setName("Riad Marrakech");
//		hotel.setDescription("welcome to our hotel");
//		hotel.setAdress("Quartier El Hana");
//		hotel.setCity(city);
//		hotelRepository.save(hotel);
//	}

}
