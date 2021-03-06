package com.example.bookingapiauth.entity;

import lombok.Getter;

@Getter
public enum Permission {
    BOOKING_READ("booking:read"),
    BOOKING_WRITE("booking:write");

    private final String permission;

    Permission(String permission) {
        this.permission = permission;
    }
}
