package com.booking.service;
import com.booking.model.City;
import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import com.booking.model.Room;
import com.booking.repository.HotelRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Transactional
public class HotelServiceTest {
    @Mock
    HotelRepository hotelRepository;

    @InjectMocks
    HotelServiceImpl hotelService;
    AutoCloseable closeable;

    @BeforeEach
    public void init() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    public void close () throws Exception {
        closeable.close();
    }

    @Test
    public void testFindById()  {
        long id = 1;
        Hotel hotel = new Hotel();
        hotel.setHotelImages(new ArrayList<HotelImage>());
        hotel.setCity(new City());
        hotel.setRoomsHotel(new ArrayList<Room>());
        hotel.setAdress(" ");

        given(hotelRepository.findById(id)).willReturn(Optional.of(hotel));
        Hotel hotelTest= hotelService.findById(id).get();
        assertEquals(hotel,hotelTest);
    }

    @Test
    public void testFindAll() {
        List<Hotel> hotels = new ArrayList<Hotel>();
        hotels.add(new Hotel());
        given(hotelRepository.findAll()).willReturn(hotels);
        List<Hotel> hotelList = hotelService.findAll();
        assertEquals(hotels,hotelList);
    }

}
