package com.booking.dto;

import com.booking.model.Hotel;
import com.booking.model.HotelImage;
import lombok.Data;

import java.util.List;

@Data
public class HotelRequest {
    private Hotel hotel;
    private List<HotelImage> hotelImageList;
    private Long city_id;

    public HotelRequest() {
    }

    public HotelRequest(Hotel hotel, List<HotelImage> hotelImageList, Long city_id) {
        this.hotel = hotel;
        this.hotelImageList = hotelImageList;
        this.city_id = city_id;
    }
}
