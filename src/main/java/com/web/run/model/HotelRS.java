package com.web.run.model;

import java.util.List;

public class HotelRS {
    private boolean success;
    private String message;
    private List<Hotel> hotels;

    // Constructors
    public HotelRS() {}

    public HotelRS(boolean success, String message, List<Hotel> hotels) {
        this.success = success;
        this.message = message;
        this.hotels = hotels;
    }

    // Getters and setters
    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Hotel> getHotels() {
        return hotels;
    }

    public void setHotels(List<Hotel> hotels) {
        this.hotels = hotels;
    }

    @Override
    public String toString() {
        return "HotelRS{" +
                "success=" + success +
                ", message='" + message + '\'' +
                ", hotels=" + hotels +
                '}';
    }
}
