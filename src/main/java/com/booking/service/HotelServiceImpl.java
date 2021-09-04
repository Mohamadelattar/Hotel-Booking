package com.booking.service;

import com.booking.model.Equipment;
import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import com.booking.repository.HotelRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(long hotelId) {
        Optional<Hotel> hotel= hotelRepository.findById(hotelId);

        if(hotel.isEmpty()){
            return null;
        }

        return hotel;
    }

    @Override
    public void save(Hotel hotel) {

        for(HotelImage hotelImage : hotel.getHotelImages() ){
            addImageToHotel(hotel,hotelImage);
        }
        hotelRepository.save(hotel);
    }

    @Override
    public void update(Hotel hotel) {

    }

    @Override
    public void deleteById(long hotelId) {
        hotelRepository.deleteById(hotelId);
    }

    private void addImageToHotel(Hotel hotel, HotelImage hotelImage){
        hotelImage.setHotel(hotel);
    }
}
