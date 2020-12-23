package com.example.bookingapiauth.controller;


import com.example.bookingapiauth.datastorage.DataStorageImpl;
import com.example.bookingapiauth.exceptions.NotFoundException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("v2/api/booking")
public class BookingController {

    DataStorageImpl dataStorage = new DataStorageImpl();

    private List<Map<String, Object>> bookingList = dataStorage.getBookingList();

    int counter = bookingList.size();

    @GetMapping
    public List<Map<String, Object>> bookingList() {
        return bookingList;
    }

    @GetMapping("{id}")
    @PreAuthorize("hasAuthority('booking:read')")
    public Map<String, Object> bookingById(@PathVariable long id) {
        return getBookingById(id);
    }

    @PostMapping
    @PreAuthorize("hasAuthority('booking:write')")
    public Map<String, Object> createBooking(@RequestBody Map<String, Object> booking) {
        Map<String, Object> newBooking = new LinkedHashMap<>();
        newBooking.put("booking_id", ++counter);
        newBooking.putAll(booking);
        bookingList.add(newBooking);
        return booking;
    }

    @PutMapping("{id}")
    @PreAuthorize("hasAuthority('booking:write')")
    public Map<String, Object> updateBooking(@PathVariable long id, @RequestBody Map<String, String> booking) {
        Map<String, Object> bookingFromDataStorage = getBookingById(id);
        bookingFromDataStorage.putAll(booking);
        bookingFromDataStorage.put("booking_id", id);
        return bookingFromDataStorage;
    }

    @DeleteMapping("{id}")
    @PreAuthorize("hasAuthority('booking:write')")
    public void delete(@PathVariable long id) {
        if (bookingList.isEmpty()) {
            bookingList = dataStorage.getBookingList();
        } else {
            Map<String, Object> booking = getBookingById(id);
            bookingList.remove(booking);
        }

    }

    private Map<String, Object> getBookingById(long id) {
        return bookingList.stream()
                .filter(booking -> booking.get("booking_id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }

}
