package com.example.bookingapiauth.datastorage.config;

import java.util.List;
import java.util.Map;

public interface DataStorage {
    List<Map<String, Object>> getBookingList();
}
