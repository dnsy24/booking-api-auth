package com.example.bookingapiauth.datastorage;


import static com.example.bookingapiauth.data.provider.DataProviderImpl.booking;

import com.example.bookingapiauth.data.BookingDates;
import com.example.bookingapiauth.datastorage.config.DataStorage;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;


public class DataStorageImpl implements DataStorage {

    private long id;
//  TODO: application.properties ???
//    @Value("${number.of.bookings}")
//    private int NUMBER_OF_BOOKINGS;
    private final int NUMBER_OF_BOOKINGS = 15;

    @Override
    public List<Map<String, Object>> getBookingList() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (int i = 1; i <= NUMBER_OF_BOOKINGS; i++) {
            list.add(createSingleBooking());
        }
        return list;
    }

    private Map<String, Object> createSingleBooking() {

        return new LinkedHashMap<>() {
            {
                put("booking_id", ++id);
                put("name", booking().createName());
                put("lastname", booking().createLastName());
                put("price", booking().createPrice());
                put("paid", booking().isPaid());
                put("city", booking().createCity());
                put("languages", booking().createLanguages());
                put("booking_dates", new BookingDates());
                put("additional_needs", booking().createAdditionalNeeds());
            }
        };

    }
}

