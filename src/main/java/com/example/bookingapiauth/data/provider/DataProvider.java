package com.example.bookingapiauth.data.provider;

import java.util.List;

public interface DataProvider {
    String createName();

    String createLastName();

    double createPrice();

    boolean isPaid();

    String createCity();

    List<String> createLanguages();

    String createAdditionalNeeds();

}